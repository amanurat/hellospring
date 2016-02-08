package com.assanai.spring.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by amanurat on 1/25/2016 AD.
 */
public class UserDemoControllerTest extends BaseControllerTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testUsersHomePage() throws Exception {
        //calling the controller with url '/users'
        mockMvc.perform(get("/users")).andDo(print())
//                .andExpect(model().attribute("userMap", new HashMap())) // checking the model already set the attribute 'userMap'
                .andExpect(view().name("users")); // checking the view show correctly
    }

    @Test
    public void testSaveUser() throws Exception {
        //calling controller with parameter
        mockMvc.perform(post("/save-user")
                .param("id", "1")
                .param("firstName", "assanai")
                .param("lastName", "manurat")
                .param("email", "assanai@gmail.com")
        )
                .andExpect(status().isFound())
                .andExpect(model().hasNoErrors()) //checking the model to ensure don't have any error
                .andExpect(redirectedUrl("/users")) //checking the url to ensure redirect to the new url
        ;

    }

    @Test
    public void testSaveUserWithoutParameterShouldValidated() throws Exception {
        //calling controller without parameter then should has errors
        mockMvc.perform(post("/save-user"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(model().hasErrors())// checking model to ensure has errors
                .andExpect(model().attributeHasErrors("user"))// checking the model name has errors
                .andExpect(model().attributeHasFieldErrors("user", "firstName", "lastName")) // checking model has a field errors
                .andExpect(view().name("user-detail"));//the url should still at the same

    }
}