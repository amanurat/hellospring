package com.assanai.spring.mvc.repository.jpa;

import com.assanai.spring.mvc.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    private SessionFactory sessionFactory;


    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }


    public List<User> findAll() {
        return entityManager.createQuery("from User").getResultList();
    }

    public void create(User user) {
//        entityManager.persist(user);
        sessionFactory.getCurrentSession().save(user);
    }

    public void update(User user) {
        entityManager.merge(user);

    }

    public void delete(User user) {
        User newEntity = entityManager.getReference(User.class, user.getId());
        entityManager.remove(newEntity);
    }

    public void delete(Integer id) {
        User newEntity = entityManager.getReference(User.class, id);
        entityManager.remove(newEntity);
    }
}
