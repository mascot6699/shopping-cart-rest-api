package com.shukla.umang.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shukla.umang.domain.Item;
import com.shukla.umang.exception.ResourceNotFoundException;
import com.shukla.umang.repository.ItemRepository;
import com.shukla.umang.service.ItemService;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * @param itemId Check if itemId exists
     * @throws ResourceNotFoundException Custom exception which sends return code as 404 with message
     */
    public Item verifyItem(Long itemId) throws ResourceNotFoundException {
        Item item = itemRepository.findOne(itemId);
        if(item == null) {
            throw new ResourceNotFoundException("Item with id " + itemId + " not found");
        }
        return item;
    }

    public Item updateItem(Long itemId, Item item) {
        this.verifyItem(itemId);
        item.setId(itemId);
        itemRepository.save(item);
        return item;
    }

    public void deleteItem(Long itemId) {
        this.verifyItem(itemId);
        itemRepository.delete(itemId);
    }

}
