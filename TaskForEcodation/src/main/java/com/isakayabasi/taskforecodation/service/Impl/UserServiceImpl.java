package com.isakayabasi.taskforecodation.service.Impl;

import com.isakayabasi.taskforecodation.model.User;
import com.isakayabasi.taskforecodation.repository.UserRepository;
import com.isakayabasi.taskforecodation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User saveUser(User user) {
        return  userRepository.save(user);
    }

    @Override
    public User testCreateFail(User user) {
        return  userRepository.save(user);
    }



    @Override
    public User updateUser(Long id, User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUserByName() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }



}
