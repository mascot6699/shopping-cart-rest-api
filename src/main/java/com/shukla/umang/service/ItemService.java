package com.shukla.umang.service;


import com.shukla.umang.domain.Item;

public interface ItemService {

    Item verifyItem(Long itemId);
    Item updateItem(Long itemId, Item item);
    void deleteItem(Long itemId);
}
