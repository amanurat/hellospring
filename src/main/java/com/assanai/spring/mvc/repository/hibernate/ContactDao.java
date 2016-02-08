package com.assanai.spring.mvc.repository.hibernate;

import com.assanai.spring.mvc.domain.Contact;

import java.io.Serializable;
import java.util.List;

/**
 * Created by amanurat on 1/3/2016 AD.
 */
public interface ContactDao {
    Contact findOne(Long id);
    List findAll();
    List<Contact> findAllWithDetail();
    Serializable create(Contact contact);
    void update(Contact contact);
    void delete(Contact contact);
}
