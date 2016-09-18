package com.assanai.spring.ioc.xml;

import com.assanai.spring.core.di.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by amanurat on 3/7/2016 AD.
 */
@ContextConfiguration(locations = "classpath:/config/spring-config-di.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DependencyInjectionQualifierTest {


    @Autowired
    @Qualifier("facebookLoginService")
    LoginService loginService;

    @Test
    public void testLogin() throws Exception {

        System.out.println(loginService);
    }
}
