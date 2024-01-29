package com.gradecalculator.gradecalculator.service.validationService;

import com.gradecalculator.gradecalculator.dao.EntityDao.UserDao;
import com.gradecalculator.gradecalculator.model.User;
import com.gradecalculator.gradecalculator.service.encryptorsService.Encryptor;
import com.gradecalculator.gradecalculator.service.managerService.UserManager;
import com.gradecalculator.gradecalculator.service.sessionService.SessionImpl;

public abstract class UserValidator implements UserManager<User> {
    private final UserDao userDao = new UserDao();
    @Override
    public User login(String username, String password) {
        String query = "SELECT t FROM User t WHERE username = '" + username + "'";
        User user =  userDao.runQuery(query);
        // Check if user exist and return null if passwords don't match
        if(user == null || !Encryptor.verify(password, user.getPassword())) return null;
        SessionImpl.getInstance(user); // set a sessionService to this user
        return user;
    }


    public abstract boolean isAuthorized(User user);


    public abstract boolean isAuthenticated(User user);
}
