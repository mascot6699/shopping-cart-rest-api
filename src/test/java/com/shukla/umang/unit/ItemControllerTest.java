package com.shukla.umang.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.shukla.umang.ShoppingCartRestApi;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The name of each test is self explanatory.
 * TODO: Implementation
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=ShoppingCartRestApi.class)
@WebAppConfiguration
public class ItemControllerTest {

    private MockMvc mockMvc;

    @Test
    public void testApisAsAnonymousUser() throws Exception {
        // Get all items apis
        mockMvc.perform(get("/v1/items")).andExpect(status().isUnauthorized());
    }

    @Test
    public void testGetAllItems() throws Exception {
        // Get all items apis

    }

    @Test
    public void testGetParticularItem() throws Exception {

    }

    @Test
    public void testGetItemNotInCatalog() throws Exception {

    }

    @Test
    public void testEditParticularItem() throws Exception {

    }

    @Test
    public void testEditItemNotInCatalog() throws Exception {

    }

    @Test
    public void testEditItemAsNonAdminUser() throws Exception {

    }

    @Test
    public void testDeleteItemAsNonAdminUser() throws Exception {

    }

    @Test
    public void testDeleteItem() throws Exception {

    }

    @Test
    public void testDeleteNonExistingItem() throws Exception {

    }

    // Behaviour expected from current code is it is mandatory although could be same
    // Patch request if that type things needs to be entertained
    @Test
    public void testEditItemWithoutName() throws Exception {

    }

}
