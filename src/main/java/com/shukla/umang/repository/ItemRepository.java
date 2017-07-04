package com.shukla.umang.repository;

import org.springframework.data.repository.CrudRepository;

import com.shukla.umang.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
