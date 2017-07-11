package com.shukla.umang.unit;


import com.shukla.umang.ShoppingCartRestApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The name of each test is self explanatory.
 * TODO: Implementation
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=ShoppingCartRestApi.class)
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mockMvc;

    @Test
    public void testApisAsAnonymousUser() throws Exception {
        //mockMvc.perform(post("/v1/user")).andExpect(status().isUnauthorized());
    }

    @Test
    public void testNoUserCanGetUserData() throws Exception {
        // mockMvc.perform(get("/v1/user")).andExpect(status().isNotImplemented());
        // mockMvc.perform(get("/v1/user/1")).andExpect(status().isNotImplemented());
    }

    // Also check password hash is not being given back.
    // Check the user created does not have isAdmin as true.
    @Test
    public void testUserCreation() throws Exception {
        // mockMvc.perform(post("/v1/user")).andExpect(status().isNotImplemented());
    }

}
