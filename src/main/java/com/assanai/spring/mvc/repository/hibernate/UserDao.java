package com.assanai.spring.mvc.repository.hibernate;

import com.assanai.spring.mvc.domain.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by amanurat on 12/27/2015 AD.
 */
public interface UserDao {
    User findOne(Long id);
    List<User> findAll();
    Serializable create(User user);
    void update(User user);
    void delete(User user);
}
