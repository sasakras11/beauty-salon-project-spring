package com.salon.service;

import com.salon.entity.User;

import java.util.Optional;

public interface UserService {

  User register(String username, String password);

  User login(String username, String password);

  public void save(User user);
}
