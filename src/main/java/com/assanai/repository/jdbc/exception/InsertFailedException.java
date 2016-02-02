package com.assanai.repository.jdbc.exception;

import org.springframework.dao.DataAccessException;

/**
 * Created by amanurat on 1/26/2016 AD.
 */
public class InsertFailedException extends DataAccessException {
    public InsertFailedException(String msg) {
        super(msg);
    }
}
