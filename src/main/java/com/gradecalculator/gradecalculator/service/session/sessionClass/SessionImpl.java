package com.gradecalculator.gradecalculator.service.session.sessionClass;


import com.gradecalculator.gradecalculator.model.User;
import com.gradecalculator.gradecalculator.service.session.sessionInterface.Session;

@SuppressWarnings("unused")
public final class SessionImpl implements Session<SessionImpl, User> {
    private static SessionImpl instance;
    private User user;

    private SessionImpl(User user) {
        this.user = user;
    }

    public static SessionImpl getInstance(User user) {
        if(instance == null) {
            instance = new SessionImpl(user);
        }
        return instance;
    }
    public static SessionImpl getInstance() {
        return instance;
    }

    public static boolean isSession(){
        return instance != null;
    }

    public User getUser() {
        return this.user;
    }

    public void cleanUserSession() {
        this.user = null;
    }

    @Override
    public String toString() {
        return "SessionImpl{" +
                "user=" + user +
                '}';
    }
}
