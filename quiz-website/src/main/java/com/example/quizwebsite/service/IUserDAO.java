package com.example.quizwebsite.service;

import com.example.quizwebsite.model.User;
import java.util.List;

public interface IUserDAO {
    User getUserById(int userId);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
}