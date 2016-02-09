package com.assanai.spring.mvc.rest;

import com.assanai.spring.mvc.domain.UserRole;
import com.assanai.spring.mvc.repository.hibernate.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by amanurat on 12/15/2015 AD.
 */
//@Controller
public class UserRoleResource {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @RequestMapping(value = "/api/roles", method = RequestMethod.GET)
    @ResponseBody
    public List<UserRole> userRoles() {
        /*List<UserRole> list = new ArrayList<>();
        list.add(new UserRole() {

            @Override
            public Integer getId() {
                return 1;
            }

            @Override
            public String getRole() {
                return "admin";
            }
        });*/

        List<UserRole> list = userRoleRepository.findAll();

        return list;
    }
}
