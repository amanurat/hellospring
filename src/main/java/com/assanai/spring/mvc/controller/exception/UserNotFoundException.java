package com.assanai.spring.mvc.controller.exception;

/**
 * Created by amanurat on 12/16/2015 AD.
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
