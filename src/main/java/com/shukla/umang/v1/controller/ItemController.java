package com.shukla.umang.v1.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shukla.umang.domain.Item;
import com.shukla.umang.repository.ItemRepository;
import com.shukla.umang.exception.ResourceNotFoundException;

import com.wordnik.swagger.annotations.Api;


@RestController("itemControllerV1")
@RequestMapping("/v1/")
@Api(value = "items", description = "Item API")
public class ItemController {

    @Inject
    private ItemRepository itemRepository;

    @RequestMapping(value="/items/{itemId}", method=RequestMethod.GET)
    public ResponseEntity<?> getItem(@PathVariable Long itemId) {
        Item item = verifyItem(itemId);
        return new ResponseEntity<> (item, HttpStatus.OK);
    }

    /**
     * @param itemId Check if itemId exists
     * @throws ResourceNotFoundException Custom exception which sends return code as 404 with message
     */
    protected Item verifyItem(Long itemId) throws ResourceNotFoundException {
        Item item = itemRepository.findOne(itemId);
        if(item == null) {
            throw new ResourceNotFoundException("Item with id " + itemId + " not found");
        }
        return item;
    }

}
