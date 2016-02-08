package com.assanai.spring.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by amanurat on 12/26/2015 AD.
 */

@Controller
public class HomeController {

    static private Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = {"/home","/*", "/index"}, method = RequestMethod.GET)
    public String home(Model model) {
        LOGGER.info("welcome to home controller...");

        model.addAttribute("message", "Hello");

        return "home";
    }


}