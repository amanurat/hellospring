package com.assanai.repository.hibernate;

import com.assanai.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by amanurat on 12/27/2015 AD.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    //Todo implement
    public User findOne(Long id) {
        return null;
    }

    //Todo implement
    public List<User> findAll() {
        return null;
    }

    //Todo implement
    public Serializable create(User user) {
        return null;
    }

    //Todo implement
    public void update(User user) {

    }

    //Todo implement
    public void delete(User user) {

    }

}
