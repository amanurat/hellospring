package com.assanai.spring.mvc.rest;

import com.assanai.spring.mvc.exception.UserNotFoundException;
import com.assanai.spring.mvc.domain.User;
import com.assanai.spring.mvc.repository.hibernate.UserRepository;
import com.assanai.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by amanurat on 12/15/2015 AD.
 */
//@Controller
public class UserResource {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    @ResponseBody
    //--
//    @Transactional
    public List<User> getUsers() throws Exception {
        List<User> users = userService.findAll();
        return users;
    }


    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable Integer id) throws UserNotFoundException {

        return userService.findUser(id);

    }



}

