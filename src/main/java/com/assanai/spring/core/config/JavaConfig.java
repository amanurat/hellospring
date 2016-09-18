package com.assanai.spring.core.config;
 
import com.assanai.spring.core.bean.annotation.AnotherBean;
import com.assanai.spring.core.bean.annotation.MyBean;
import com.assanai.spring.core.bean.javaconfig.MyJavaBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
 
    @Bean
    public MyJavaBean myJavaBean(){
        return  new MyJavaBean();
    }
     
    @Bean(name = "anotherBean2")
    public AnotherBean anotherBean(){
        return new AnotherBean();
    }
}