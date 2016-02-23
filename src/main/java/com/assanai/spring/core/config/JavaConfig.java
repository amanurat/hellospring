package com.assanai.spring.core.config;
 
import com.assanai.spring.core.bean.AnotherBean;
import com.assanai.spring.core.bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
 
    @Bean
    public MyBean myBean(){
        return  new MyBean();
    }
     
    @Bean(name = "anotherBean2")
    public AnotherBean anotherBean(){
        return new AnotherBean();
    }
}