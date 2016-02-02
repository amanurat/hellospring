package com.assanai.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by amanurat on 1/19/2016 AD.
 */
@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestScopeController {

    private int increment = 0;

    @RequestMapping(value = "/shopping")
    @ResponseBody
    public String login() {
        increment++;
        System.out.println(this.getClass().hashCode() + "increment value : "+ increment);
        return "login";
    }


    public void showRequestScope() {
        increment++;
        System.out.println("request scope : " + increment);
    }
}
