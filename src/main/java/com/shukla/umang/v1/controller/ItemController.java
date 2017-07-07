package com.shukla.umang.v1.controller;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shukla.umang.domain.Item;
import com.shukla.umang.dto.error.ErrorDetail;
import com.shukla.umang.repository.ItemRepository;
import com.shukla.umang.exception.ResourceNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * All apis endpoints related to items stay here.
 */
@RestController("itemControllerV1")
@RequestMapping("/v1/")
@Api(value = "items", description = "Item API")
public class ItemController {

    @Inject
    private ItemRepository itemRepository;

    @RequestMapping(value="/items", method=RequestMethod.GET)
    @ApiOperation(value = "Retrieves all the items", response=Item.class, responseContainer="List")
    public ResponseEntity<Page<Item>> getAllPolls(Pageable pageable) {
        Page<Item> allItems = itemRepository.findAll(pageable);
        return new ResponseEntity<>(allItems, HttpStatus.OK);
    }

    @RequestMapping(value="/items/{itemId}", method=RequestMethod.GET)
    @ApiOperation(value = "Get details of particular item", response=Item.class)
    @ApiResponses(value = {
            @ApiResponse(code=200, message="", response=Item.class),
            @ApiResponse(code=404, message="Item with id not found", response=ErrorDetail.class)
    })
    public ResponseEntity<?> getItem(@ApiParam @PathVariable Long itemId) {
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
