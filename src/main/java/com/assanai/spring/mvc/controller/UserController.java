package com.assanai.spring.mvc.controller;

import com.assanai.spring.mvc.domain.User;
import com.assanai.spring.mvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@RequestMapping("/users")
public class UserController {

    private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private static final String VIEW_USERS = "/users";
    private static final String REDIRECT_VIEW_USERS = "redirect:/users";
    public static final String VIEW_USERS_LIST = "/users/list";
    public static final String VIEW_USERS_DETAIL = "/users/detail";

    @Autowired
    private UserService userService;

    // To enable custom validation using initBinder()
    /*
    @Autowired
    private UserValidator userValidator;

   @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(userValidator);
    }*/

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @Transactional
    public String list(Model model) {
        System.out.println("**** TEST222333 ****");
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return VIEW_USERS_LIST;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") Integer id, Model model) throws Exception {
        LOGGER.info("id : "+ id);

        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return VIEW_USERS_DETAIL;
    }

    @ModelAttribute("genders")
    public String[] genders() {
        return new String[]{"Male", "Female"};
    }

    @ModelAttribute("user")
    public User initialize() {
        return new User();
    }


    @RequestMapping(value = "/init", method = { RequestMethod.POST, RequestMethod.GET})
    public String init() {
        return VIEW_USERS_DETAIL;
    }

    @RequestMapping(value = "/add", method = { RequestMethod.POST, RequestMethod.GET})
    public String add(@Validated @ModelAttribute User user, BindingResult bindingResult) throws Exception {

        LOGGER.info("into add...");

        if (bindingResult.hasErrors()) {
            return VIEW_USERS_DETAIL;
        }

        try {
            userService.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return REDIRECT_VIEW_USERS;
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Validated @ModelAttribute User user, BindingResult bindingResult) {

        try {
            if (bindingResult.hasErrors()) {
                return VIEW_USERS_DETAIL;
            }

            userService.update( user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return REDIRECT_VIEW_USERS;
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public String remove(@PathVariable("id") Integer id) throws Exception {

        User user = userService.findUser(id);
        try {
            if (user != null) {
                userService.delete(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return REDIRECT_VIEW_USERS;
    }
}
