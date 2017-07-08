package com.shukla.umang.v1.controller;

import java.net.URI;
import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shukla.umang.domain.Item;
import com.shukla.umang.dto.error.ErrorDetail;
import com.shukla.umang.repository.ItemRepository;
import com.shukla.umang.service.Impl.ItemServiceImpl;
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

    @Inject
    private ItemServiceImpl itemServiceImpl;

    @RequestMapping(value="/items", method=RequestMethod.GET)
    @ApiOperation(value = "Retrieves all the items", response=Item.class, responseContainer="List")
    public ResponseEntity<Page<Item>> getAllItems(Pageable pageable) {
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
        Item item = itemServiceImpl.verifyItem(itemId);
        return new ResponseEntity<> (item, HttpStatus.OK);
    }


    @RequestMapping(value="/items", method=RequestMethod.POST)
    @ApiOperation(value = "Creates a new Item", notes="The newly created item Id will be sent in the location response header",
        response = Void.class)
    @ApiResponses(value = {
        @ApiResponse(code=201, message="Item Created Successfully", response=Void.class),
        @ApiResponse(code=500, message="Error creating Item", response=ErrorDetail.class)
    })
    public ResponseEntity<Void> createItem(@Valid @RequestBody Item item) {
        item = itemRepository.save(item);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newItemUri = ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}")
            .buildAndExpand(item.getId()).toUri();
        responseHeaders.setLocation(newItemUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @RequestMapping(value="/items/{itemId}", method=RequestMethod.PUT)
    @ApiOperation(value = "Updates given Item", response=Void.class)
    @ApiResponses(value = {
        @ApiResponse(code=200, message="", response=Void.class),
        @ApiResponse(code=404, message="Unable to find Item", response=ErrorDetail.class)
    })
    public ResponseEntity<Void> updateItem(@RequestBody Item item, @PathVariable Long itemId) {
        itemServiceImpl.updateItem(itemId, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value="/items/{itemId}", method=RequestMethod.DELETE)
    @ApiOperation(value = "Deletes given Item", response=Void.class)
    @ApiResponses(value = {
        @ApiResponse(code=200, message="", response=Void.class),
        @ApiResponse(code=404, message="Unable to find Item", response=ErrorDetail.class)
    })
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        itemServiceImpl.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
