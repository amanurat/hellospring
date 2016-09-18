package com.assanai.spring.core.bean.xml;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class MyBean {
 
    private String name;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return "MyBean [name=" + name + "]";
    }
     
}