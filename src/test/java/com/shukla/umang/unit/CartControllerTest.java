package com.shukla.umang.unit;

import javax.inject.Inject;

import com.shukla.umang.v1.controller.CartController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.hasItem;

import com.shukla.umang.ShoppingCartRestApi;
import com.shukla.umang.repository.CartRepository;

/**
 * The name of each test is self explanatory.
 * TODO: Implementation
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=ShoppingCartRestApi.class)
@WebAppConfiguration
public class CartControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private CartRepository cartRepository;

    @Before
    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        CartController cartController = new CartController();
//        ReflectionTestUtils.setField(cartController, "cartRepository", cartRepository);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();
    }

    @Test
    public void testApiAsAnonymousUser() throws Exception {
        // Get the cart
        // mockMvc.perform(get("/v1/showCart")).andExpect(status().isUnauthorized());
    }

    @Test
    public void testGetCart() throws Exception {

    }

    @Test
    public void testGetEmptyCart() throws Exception {

    }

    @Test
    public void testUpdateCartWithFirstItem() {

    }

    @Test
    public void testUpdateCartAddingItemInCart() throws Exception {

    }

    @Test
    public void testUpdateCartAddingItemNotInCart() throws Exception {

    }

    @Test
    public void testUpdateCartAddingItemNotInCatalog() throws Exception {

    }


    @After
    public void teardown() { }
}
