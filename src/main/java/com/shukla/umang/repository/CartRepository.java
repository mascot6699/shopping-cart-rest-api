package com.shukla.umang.repository;

import com.shukla.umang.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    public Cart findByUserId(Long userId);
}
