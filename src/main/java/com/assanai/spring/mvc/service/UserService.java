package com.assanai.spring.mvc.service;

import com.assanai.spring.mvc.controller.exception.UserNotFoundException;
import com.assanai.spring.mvc.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by amanurat on 2/5/2016 AD.
 */
public interface UserService {
    @Transactional(readOnly = true)
    User findUser(Integer id) throws UserNotFoundException;

    @Transactional(readOnly = true)
    List<User> findAll();

    @Transactional
    void create(User user);

    @Transactional
    void update(User user);

    @Transactional
    void delete(User user);

    @Transactional
    void delete(Integer id);
}
