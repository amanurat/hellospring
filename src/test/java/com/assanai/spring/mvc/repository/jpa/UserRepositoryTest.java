package com.assanai.spring.mvc.repository.jpa;

import com.assanai.spring.mvc.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by amanurat on 2/8/2016 AD.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context/application-context.xml")
@Transactional

public class UserRepositoryTest {


//    @Autowired private UserRepository userRepository;

    @Test
    public void testFindById() throws Exception {

//        List<User> users = userRepository.findAll();
//        System.out.println(users);
    }

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testDelete1() throws Exception {

    }
}