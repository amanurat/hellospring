package com.assanai.repository.hibernate;

import com.assanai.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by amanurat on 12/27/2015 AD.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    public User findOne(Long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

}
