package com.assanai.spring.core.bean.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by amanurat on 3/7/2016 AD.
 */
public class WiredWithAnnotationApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config-annotation.xml");

        MyBean myBean = context.getBean(MyBean.class);
        System.out.println(myBean.getName());

        AnotherBean anotherBean = context.getBean(AnotherBean.class);
        System.out.println(anotherBean);

        //solve get context with same interface must specific bean name
        OneBean oneBean = (OneBean) context.getBean("oneBean",IBean.class);
        System.out.println(oneBean);

        TwoBean twoBean = (TwoBean) context.getBean("twoBean", IBean.class);
        System.out.println(twoBean);
    }
}
