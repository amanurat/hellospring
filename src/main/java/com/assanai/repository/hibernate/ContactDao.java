package com.assanai.repository.hibernate;

import com.assanai.domain.Contact;

import java.io.Serializable;
import java.util.List;

/**
 * Created by amanurat on 1/3/2016 AD.
 */
public interface ContactDao {
    java.util.List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(Long id);
    Serializable save(Contact contact);
    void delete(Contact contact);
}
