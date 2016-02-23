package com.assanai.spring.mvc.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by amanurat on 2/10/2016 AD.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/context/application-context.xml")
@Transactional
public class UserServiceImplTest {

    @Test
    public void testDelete() throws Exception {

    }
}