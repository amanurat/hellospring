package com.assanai.repository.hibernate;

import com.assanai.domain.User;

/**
 * Created by amanurat on 12/27/2015 AD.
 */
public interface UserDao {
    User findOne(Long id);
}
