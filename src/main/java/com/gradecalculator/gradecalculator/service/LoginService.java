package com.gradecalculator.gradecalculator.service;

import com.gradecalculator.gradecalculator.helper.enums.UserAuthority;
import com.gradecalculator.gradecalculator.model.User;
import com.gradecalculator.gradecalculator.service.session.sessionClass.SessionImpl;
import com.gradecalculator.gradecalculator.service.validation.UserValidator;


public class LoginService extends UserValidator {

    @Override
    public boolean isAuthorized(User user) {
        return user.getUserAuthorities().contains(UserAuthority.INSTRUCTOR);
    }

    @Override
    public boolean isAuthenticated(User user) {
        return SessionImpl.isSession();
    }
}
