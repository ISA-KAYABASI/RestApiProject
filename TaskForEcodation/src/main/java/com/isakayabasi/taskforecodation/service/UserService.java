package com.isakayabasi.taskforecodation.service;

import com.isakayabasi.taskforecodation.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(User user);

    User testCreateFail(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    List<User> getUserByName();

}
