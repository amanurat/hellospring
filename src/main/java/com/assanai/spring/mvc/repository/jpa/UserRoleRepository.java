package com.assanai.spring.mvc.repository.jpa;

import com.assanai.spring.mvc.domain.UserRole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by amanurat on 12/15/2015 AD.
 */
//@Repository
public class UserRoleRepository {

//    @PersistenceContext
    private EntityManager entityManager;


    public UserRole findById(Integer id) {
        return entityManager.find(UserRole.class, id);
    }

    public List<UserRole> findAll() {
        return entityManager.createQuery("from UserRole").getResultList();
    }
}
