package com.assanai.spring.core.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by amanurat on 2/3/2016 AD.
 */
@Controller
public class LoginSocialController {

    @Autowired
    @Qualifier("facebookLoginService")
    private LoginService loginService;

    public String login() {

        boolean authenticated = loginService.login("user", "passs");
        System.out.println();

        return "home";
    }


}
