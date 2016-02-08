package com.assanai.spring.mvc.controller.demo;

import com.assanai.spring.mvc.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

//@Controller(value = "/demo/users")
public class UserDemoController {

    private Logger LOGGER = LoggerFactory.getLogger(UserDemoController.class);

    private Map<String, User> userMap;

    private int i = 1;

    public UserDemoController() {
        userMap = new HashMap<String, User>();
    }

    @ModelAttribute("userMap")
    public Map<String, User> userMap() {
        return this.userMap;
    }

    @RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST})
    private String users(Model model) {

        model.addAttribute("userMap", this.userMap);
        return "/demo/users";
    }


    @RequestMapping(value = "/detail", method = { RequestMethod.GET, RequestMethod.POST} )
    private String userDetail(Model model) {

        model.addAttribute("user", new User());

        return "/demo/user-detail";
    }

    @RequestMapping(value = "/save-user", method = {RequestMethod.POST, RequestMethod.GET})
    private String saveUser(@Validated @ModelAttribute User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/demo/user-detail";
        }

        user.setId(i++);
        this.userMap.put(String.valueOf(user.getId()), user);

        return "redirect:/demo/users";
    }

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    private String getUserEdit(@PathVariable("key") String key, Model model) {

        User user = this.userMap.get(key);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "user-detail";
    }

    @RequestMapping(value = "/{key}/edit", method = RequestMethod.POST)
    private String editUser(@PathVariable("key") String key, @ModelAttribute User model) {

        User user = this.userMap.get(key);

        if (user == null) {
            return "/demo/user-detail";
        }

        user.setUserName(model.getUserName());
        user.setPassword(model.getPassword());

        return "redirect:/demo/users";
    }

    @RequestMapping(value = "/{key}/delete", method = RequestMethod.GET)
    private String deleteUser(@PathVariable("key") String key) {

        this.userMap.remove(key);

        return "redirect:/demo/users";
    }
    
}
