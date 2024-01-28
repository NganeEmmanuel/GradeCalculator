package com.gradecalculator.gradecalculator.service.managers;

public interface UserManager<T> {
    T login(String username, String password);

    /**
     *
     * @param t object being assessed if it is authorized
     * @return true if it has the designated authority and false if not
     */
    boolean isAuthorized(T t);

    /**
     *
     * @param t Object being assessed if it is authenticated
     * @return true is it authenticated and false otherwise
     */
    boolean isAuthenticated(T t);
}
