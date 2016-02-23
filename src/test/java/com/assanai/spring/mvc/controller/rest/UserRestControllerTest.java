package com.assanai.spring.mvc.controller.rest;

import com.assanai.spring.mvc.domain.User;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by amanurat on 2/10/2016 AD.
 */
public class UserRestControllerTest {

    @Test
    public void listUserWorksOK() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<List> result = template.getForEntity("http://localhost:8081/hellospring/rest/users", List.class);
        assertNotNull(result);
        assertNotNull(result.getBody());
        assertThat(result.getBody().size(), is(3));
    }

    @Test
    public void addUserWorksOK() {
        RestTemplate template = new RestTemplate();
        User user = new User("simon", "simon");

        ResponseEntity<Void> resultSave = template.postForEntity("http://localhost:8081/hellospring/rest/users", user, Void.class);
        assertNotNull(resultSave);
    }

}
