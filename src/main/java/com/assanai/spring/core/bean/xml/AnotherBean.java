package com.assanai.spring.core.bean.xml;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class AnotherBean {
 
    private MyBean myBean;

    public MyBean getMyBean() {
        return myBean;
    }

    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }
 
    @Override
    public String toString() {
        return "AnotherBean [myBean=" + myBean + "]";
    }
     
     
}