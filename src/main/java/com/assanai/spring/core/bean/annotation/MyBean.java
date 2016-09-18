package com.assanai.spring.core.bean.annotation;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
 
@Component
public class MyBean {
 
    private String name = "default";
 
    public String getName() {
        return name;
    }
 
    @Value(value="AnnotationBean")
    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return "MyBean [name=" + name + "]";
    }
     
}