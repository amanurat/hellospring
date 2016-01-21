package com.assanai.service;

import com.assanai.bean.ShoppingCart;
import com.assanai.controller.ShoppingCartController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by amanurat on 1/19/2016 AD.
 */

@Component
public class ShoppingCartService {

//    @Autowired
//    private ShoppingCartController shoppingCartController;
//
//    public void invokeLogin() {
//        shoppingCartController.showRequestScope();
//    }

    @Autowired
    private ShoppingCart shoppingCart;

    public void add() {

        shoppingCart.add();
    }


    public int getBalance() {
        return shoppingCart.getBalance();
    }

}
