package com.mengxuegu.springboot.service;

import com.mengxuegu.springboot.entities.User;

import java.util.List;

public interface UserService {
    public User getUserByUsername(String username);

    public List<User> getUsers(User user);

    public User getUserById(Integer id);

    public int addUser(User user);

    public int deleteUserById(Integer id);

    public int updateUser(User user);
}
