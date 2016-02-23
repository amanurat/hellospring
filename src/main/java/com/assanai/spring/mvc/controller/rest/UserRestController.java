package com.assanai.spring.mvc.controller.rest;


import javax.servlet.http.HttpServletResponse;

import com.assanai.spring.core.bean.Person;
import com.assanai.spring.mvc.domain.User;
import com.assanai.spring.mvc.exception.UserNotFoundException;
import com.assanai.spring.mvc.repository.hibernate.UserRepository;
import com.assanai.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/rest")
public class UserRestController {

    public UserRestController() {
        System.out.println("init RestController");
    }

    //this method responses to GET request http://localhost/hello-spring/rest/users/person
    // return Person object as json

    @RequestMapping(value = "person", method = RequestMethod.GET)
    public
    @ResponseBody
    Person get(HttpServletResponse res) {

        Person person = new Person();
        person.setId(1);
        person.setName("Assanai Manurat");

        return person;
    }

    //this method response to POST request http://localhost/hello-spring/rest/users/person
    // receives json data sent by client --> map it to Person object
    // return Person object as json
    @RequestMapping(value = "person", method = RequestMethod.POST)
    public
    @ResponseBody
    Person post(@RequestBody final Person person) {
        System.out.println(person.getId() + " " + person.getName());
        return person;
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void save(@RequestBody User user) {
        try {
            userService.create(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public List<User> list() {
        List<User> users = userService.findAll();
        return users;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    User get(@PathVariable("id") int id) throws UserNotFoundException {
        return userService.findUser(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable("id") int id, @RequestBody User user) {
        userService.update(user);



    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        userService.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}

