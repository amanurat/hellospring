package com.assanai.spring.core.bean.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by amanurat on 2/26/2016 AD.
 */
public class WiredWithXmlApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config-xml.xml");
        MyBean myBean = (MyBean) context.getBean("myBean");

        System.out.println(myBean.getName());

    }

}
