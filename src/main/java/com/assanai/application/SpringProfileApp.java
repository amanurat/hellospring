package com.assanai.application;

import com.assanai.spring.core.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by amanurat on 2/9/2016 AD.
 */
public class SpringProfileApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("production"); //or production
        ctx.scan("com.assanai.spring.core"); // register all @Configuration classes
        //ctx.register(SpringConfigDev.class);
        ctx.refresh();
        Person person = (Person)ctx.getBean("person");


        System.out.println("Person: "+person);
    }
}
