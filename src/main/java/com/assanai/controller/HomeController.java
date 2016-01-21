package com.assanai.controller;

import com.assanai.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by amanurat on 12/26/2015 AD.
 */

@Controller
public class HomeController {

    static private Logger LOGGER = LoggerFactory.getLogger(HomeController.class);


    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        LOGGER.info("welcome to home controller...");
        return "home";
    }
    @RequestMapping(value = "/request-scope", method = RequestMethod.GET)
    public String requestScope() {
        LOGGER.info("demonstration spring request scope bean...");

        LOGGER.info("add...");
        shoppingCartService.add();


        LOGGER.info("balance...");
        LOGGER.info("result : " + shoppingCartService.getBalance());
        return "home";
    }



}