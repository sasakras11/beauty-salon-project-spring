package com.salon.service.impl;

import com.salon.entity.Role;
import com.salon.entity.User;
import com.salon.exception.LoginCredentialsException;
import com.salon.exception.NotValidParameterException;
import com.salon.exception.UserIsRegisteredException;
import com.salon.repository.UserRepository;
import com.salon.service.DataParser;
import com.salon.service.PasswordEncoder;
import com.salon.service.UserService;
import com.salon.service.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final Validator validator;
  private final DataParser dataParser;

  @Override
  public User register(String username, String password) {

    validator.validate(username, password);
    if (!userRepository.findUserByUsername(username).isPresent()) {
      User user =
          User.builder()
              .username(username)
              .password(passwordEncoder.encode(password))
              .role(Role.CLIENT)
              .build();
      userRepository.save(user);
      log.info(
          String.format(
              "user with username [%s] and password [%s] registered successfully",
              username, password));

      return user;

    } else {
      throw new UserIsRegisteredException("registration");
    }
  }

  @Override
  public User login(String username, String password) {

    Optional<User> byUsername = userRepository.findUserByUsername(username);
    boolean loggedIn = false;
    if (byUsername.isPresent()) {
      loggedIn = passwordEncoder.matches(password, byUsername.get().getPassword());
    }

    if (!loggedIn) {
      throw new LoginCredentialsException("start");
    }
    log.info(
        String.format(
            "user with username [%s] and password [%s] logged in successfully",
            username, password));
    return byUsername.get();
  }

  @Override
  public void save(User user) {
    userRepository.save(user);
  }

  @Override
  public List<User> findAllMastersBySalonId(String salonId) {
    return dataParser
        .parseInt(salonId)
        .map(userRepository::findAllMastersBySalonId)
        .orElseThrow(
            () ->
                new NotValidParameterException(
                    String.format("request param salonId - [%s] is noy valid", salonId)));
  }
}
