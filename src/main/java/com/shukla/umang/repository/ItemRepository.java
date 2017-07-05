package com.shukla.umang.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shukla.umang.domain.Item;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

}
