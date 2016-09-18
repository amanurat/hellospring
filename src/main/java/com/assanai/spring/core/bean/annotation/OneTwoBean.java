package com.assanai.spring.core.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by amanurat on 3/7/2016 AD.
 */
@Component
public class OneTwoBean {

    @Autowired
    private IBean oneBean;


}
