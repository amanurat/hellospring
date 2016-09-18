package com.assanai.spring.core.bean.annotation;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by amanurat on 3/7/2016 AD.
 */
@ContextConfiguration(locations =  "classpath:/config/spring-config-annotation.xml")
public class WiredWithAnnotationTest {


    @Autowired
    private OneBean oneBean;

    @Test
    public void test() {
        System.out.println(oneBean);
    }

}
