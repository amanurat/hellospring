package com.assanai.spring.mvc.repository.hibernate;

import com.assanai.spring.mvc.domain.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by amanurat on 1/3/2016 AD.
 */

//@Transactional
@Repository
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Contact findOne(Long id) {
        return (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
    }

    public List<Contact> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Contact c").list();
    }

    public List<Contact> findAllWithDetail() {
        return sessionFactory.getCurrentSession().createQuery("from Contact c left join fetch c.contactTelDetails").list();
    }

    public Serializable create(Contact contact) {
        return sessionFactory.getCurrentSession().save(contact);
    }
    public void update(Contact contact) {
        sessionFactory.getCurrentSession().update(contact);
    }

    public void delete(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);

    }
}
