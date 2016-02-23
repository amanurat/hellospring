package com.assanai.spring.mvc.repository.hibernate;

import com.assanai.spring.mvc.domain.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by amanurat on 12/15/2015 AD.
 */
@Repository
public class UserRoleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public UserRole findById(Integer id) {
        return (UserRole) sessionFactory.getCurrentSession().get(UserRole.class, id);
    }

    public List<UserRole> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from UserRole").list();
    }
}
