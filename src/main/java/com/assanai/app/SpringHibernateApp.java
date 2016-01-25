package com.assanai.app;

import com.assanai.domain.Contact;
import com.assanai.repository.hibernate.ContactDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by amanurat on 1/3/2016 AD.
 */
public class SpringHibernateApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/test-context-annotation.xml");

        ContactDao contactDao = context.getBean(ContactDao.class);

        List<Contact> contacts = contactDao.findAll();

        System.out.println(contacts);


    }
}
