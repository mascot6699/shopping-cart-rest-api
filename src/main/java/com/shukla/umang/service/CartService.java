package com.shukla.umang.service;

import com.shukla.umang.domain.Cart;
import com.shukla.umang.dto.request.AddToCartRequest;

public interface CartService {

    Cart addToCart(Long Id, AddToCartRequest addToCartRequest);
    Cart showCart(Long Id);
}
