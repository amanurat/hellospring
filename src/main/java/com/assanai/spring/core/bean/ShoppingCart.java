package com.assanai.spring.core.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by amanurat on 1/19/2016 AD.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
public class ShoppingCart implements Shopping {
    int balance = 0;
    public void add() {

        this.balance++;
    }

    public int getBalance() {
        return balance;
    }

}
