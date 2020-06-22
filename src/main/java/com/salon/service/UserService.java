package com.salon.service;

import com.salon.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

  User register(String username, String password);

  User login(String username, String password);

   void save(User user);

   List<User> findAllMastersBySalonId(String salonId);


}
