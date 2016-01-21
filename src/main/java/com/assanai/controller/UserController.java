package com.assanai.controller;

import com.assanai.domain.User;
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

@Controller
public class UserController {

    private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private Map<String, User> userMap;

    private long i = 1;

    public UserController() {
        userMap = new HashMap<String, User>();
    }

    @ModelAttribute("userMap")
    public Map<String, User> userMap() {
        return this.userMap;
    }

    @RequestMapping(value = "/users", method = { RequestMethod.GET, RequestMethod.POST})
    private String users(Model model) {

        model.addAttribute("userMap", this.userMap);
        return "users";
    }


    @RequestMapping(value = "/user-detail", method = RequestMethod.GET)
    private String userDetail(Model model) {

        model.addAttribute("user", new User());

        return "user-detail";
    }

    @RequestMapping(value = "/save-user", method = {RequestMethod.POST, RequestMethod.GET})
    private String saveUser(@Validated @ModelAttribute User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user-detail";
        }

        user.setId(i++);
        this.userMap.put(String.valueOf(user.getId()), user);

        return "redirect:/users";
    }

    @RequestMapping(value = "/user/{key}", method = RequestMethod.GET)
    private String getUserEdit(@PathVariable("key") String key, Model model) {

        User user = this.userMap.get(key);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "user-detail";
    }

    @RequestMapping(value = "/user/{key}/edit", method = RequestMethod.POST)
    private String editUser(@PathVariable("key") String key, @ModelAttribute User model) {

        User user = this.userMap.get(key);

        if (user == null) {
            return "user-detail";
        }

        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());

        return "redirect:/users";
    }

    @RequestMapping(value = "/user/{key}/delete", method = RequestMethod.GET)
    private String deleteUser(@PathVariable("key") String key) {

        this.userMap.remove(key);

        return "redirect:/users";
    }
    
}
