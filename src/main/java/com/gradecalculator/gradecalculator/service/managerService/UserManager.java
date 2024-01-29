package com.gradecalculator.gradecalculator.service.managerService;

public interface UserManager<T> {
    /**
     *
     * @param username username of user that needs access to the system
     * @param password password of user that needs access to the system. This was created when user was added
     * @return new object if present in the database
     * @see com.gradecalculator.gradecalculator.service.encryptorsService.Encryptor for password encyption when adding user
     */
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
