package com.assanai.service;

import com.assanai.bean.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by amanurat on 1/19/2016 AD.
 */

/**
 * Demonstration to use spring request scope that should enable proxyMode attribute (INTERFACE/TARGET_CLASS)
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestScopeServiceImpl implements RequestScopeService {


    @Autowired
    private ShoppingCart shoppingCart;

    public void add() {

        shoppingCart.add();
    }


    public int getBalance() {
        return shoppingCart.getBalance();
    }

}
