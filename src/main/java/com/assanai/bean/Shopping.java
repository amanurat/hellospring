package com.assanai.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by amanurat on 1/19/2016 AD.
 */

public interface Shopping {
    void add();

    int getBalance();
}
