package com.assanai.repository.hibernate;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amanurat on 12/27/2015 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context-annotation.xml")
@Transactional
public class UserDaoImplTest {


    @Autowired
    private UserDao userDao;


    @Test
    public void testFindOne() throws Exception {

        System.out.println(userDao.findOne(1l));

    }
}