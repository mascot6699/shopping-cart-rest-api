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

import com.wordnik.swagger.annotations.Api;


@RestController("itemControllerV1")
@RequestMapping("/v1/")
@Api(value = "items", description = "Item API")
public class ItemController {

    @Inject
    private ItemRepository itemRepository;

    @RequestMapping(value="/items/{itemId}", method=RequestMethod.GET)
    public ResponseEntity<?> getItem(@PathVariable Long itemId) {
        Item p = itemRepository.findOne(itemId);
        return new ResponseEntity<> (p, HttpStatus.OK);
    }

}