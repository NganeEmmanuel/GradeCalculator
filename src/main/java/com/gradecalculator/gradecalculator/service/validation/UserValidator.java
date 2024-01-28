package com.gradecalculator.gradecalculator.service.validation;

import com.gradecalculator.gradecalculator.dao.EntityDao.UserDao;
import com.gradecalculator.gradecalculator.model.User;
import com.gradecalculator.gradecalculator.service.encryptors.Encryptor;
import com.gradecalculator.gradecalculator.service.managers.UserManager;
import com.gradecalculator.gradecalculator.service.session.sessionClass.SessionImpl;

public abstract class UserValidator implements UserManager<User> {
    private final UserDao userDao = new UserDao();
    @Override
    public User login(String username, String password) {
        String encryptedPassword = Encryptor.encrypt(password);
        System.out.println(encryptedPassword); //todo comment this line out or remove it
        String query = "SELECT t FROM users t WHERE username = '" + username + "'";
        User user =  userDao.runQuery(query);
        if(user == null || !Encryptor.verify(password, user.getPassword())) return null;
        SessionImpl.getInstance(user);
        return user;
    }


    public abstract boolean isAuthorized(User user);


    public abstract boolean isAuthenticated(User user);
}
