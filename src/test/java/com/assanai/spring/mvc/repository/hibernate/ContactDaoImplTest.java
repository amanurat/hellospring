package com.assanai.spring.mvc.repository.hibernate;

import com.assanai.spring.mvc.domain.Contact;
import com.assanai.spring.mvc.domain.ContactTelDetail;
import com.assanai.spring.mvc.domain.Hobby;
import org.hibernate.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by amanurat on 1/3/2016 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/context/application-context.xml")
@Transactional
public class ContactDaoImplTest {


    @Autowired
    private ContactDao contactDao;

    @Test
    public void testFindAll() throws Exception {

        List<Contact> contactList = contactDao.findAll();

        System.out.println(contactList);


        listContactsWithDetail(contactList);
    }

    private  void listContactsWithDetail(List<Contact> contacts) {
        System.out.println("");
        System.out.println("Listing contacts with details:");
        for (Contact contact: contacts) {
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetail contactTelDetail: contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }
            if (contact.getHobbies() != null) {
                for (Hobby hobby: contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
            System.out.println();
        }
    }

    @Test
    public void testFindAllWithDetail() throws Exception {

        List<Contact> contacts = contactDao.findAllWithDetail();
        System.out.println(contacts);

        for (Contact contact : contacts) {
            System.out.println(contact.getFirstName());
            Set<ContactTelDetail> details = contact.getContactTelDetails();
            for (ContactTelDetail detail : details) {
                System.out.print("\t"+ detail.getId());
            }
            System.out.println();
        }
    }

    @Test
    public void testFindOneShouldFound() throws Exception {

        Contact contact = contactDao.findOne(1l);
        System.out.println(contact.getFirstName());
        assertNotNull(contact);
    }
    @Test(expected = ObjectNotFoundException.class)
    public void testFindOneShouldThrowException() throws Exception {

        Contact contact = contactDao.findOne(5l);
        fail("should be throw ObjectNotFoundException");

    }

//    @Test
    public void testSave() throws Exception {
        Contact contact = new Contact();
        contact.setFirstName("Assanai");
        contact.setLastName("Manurat");

        contactDao.create(contact);

        Contact contactSaved = contactDao.findOne(contact.getId());
        Assert.assertEquals(contactSaved.getFirstName(), "Assanai");
    }

    @Test
    public void testDelete() throws Exception {

    }
}