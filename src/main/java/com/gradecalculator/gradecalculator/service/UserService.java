package com.gradecalculator.gradecalculator.service;


import com.gradecalculator.gradecalculator.dao.EntityDao.UserDao;
import com.gradecalculator.gradecalculator.model.User;

import java.util.List;

@SuppressWarnings("unused")
public class UserService {
    private final UserDao userDao;
    public UserService(){
        this.userDao = new UserDao();
    }
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers(){
        return userDao.findAll();
    }

    public User getUserById(Long selectedTransactionId) {
        return userDao.findById(selectedTransactionId).orElse(null);
    }

    public User addUser(User user) {
        return userDao.add(user);
    }
}
