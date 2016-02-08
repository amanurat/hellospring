package com.assanai.spring.mvc.controller.scope;

import com.assanai.spring.mvc.service.RequestScopeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by amanurat on 1/19/2016 AD.
 */
@Controller
public class RequestScopeController {

    static private Logger LOGGER = LoggerFactory.getLogger(RequestScopeController.class);

    @Autowired private RequestScopeService requestScopeService;


    @RequestMapping(value = "/request-scope", method = RequestMethod.GET)
    public String requestScope() {
        LOGGER.info("demonstration spring request scope bean...");

        LOGGER.info("add...");
        requestScopeService.add();

        LOGGER.info("balance...");
        LOGGER.info("result : " + requestScopeService.getBalance());
        return "home";
    }

}
