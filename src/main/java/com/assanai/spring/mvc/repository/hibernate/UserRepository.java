package com.assanai.spring.mvc.repository.hibernate;

import com.assanai.spring.mvc.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {


    @Autowired
    private SessionFactory sessionFactory;


    public User findById(Integer id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }


    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public void delete(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
}
