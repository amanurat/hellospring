package com.assanai.application;

import com.assanai.spring.core.bean.AnotherBean;
import com.assanai.spring.core.config.JavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by amanurat on 2/9/2016 AD.
 */
public class SpringJavaBasedConfigApp {

    public static void main(String[] args) {
        ApplicationContext ctxXML = new ClassPathXmlApplicationContext("config/XMLConfig.xml");
        AnotherBean anotherBean = (AnotherBean) ctxXML.getBean("anotherBean");

        System.out.println( anotherBean);

        //---------------------------------------


        ApplicationContext ctxAnnotation = new ClassPathXmlApplicationContext("config/XMLConfig-Annotation.xml");
        anotherBean  = (AnotherBean) ctxAnnotation.getBean("anotherBean");

        System.out.println( anotherBean);

        //---------------------------------------


        ApplicationContext ctxJavaConfig = new AnnotationConfigApplicationContext(JavaConfig.class);
        anotherBean = (AnotherBean) ctxJavaConfig.getBean("anotherBean2");

        System.out.println( anotherBean);
    }
}
