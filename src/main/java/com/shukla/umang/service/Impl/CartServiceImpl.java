package com.shukla.umang.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shukla.umang.domain.Cart;
import com.shukla.umang.domain.Item;
import com.shukla.umang.domain.User;
import com.shukla.umang.domain.CartItem;
import com.shukla.umang.dto.request.AddToCartRequest;
import com.shukla.umang.exception.ResourceNotFoundException;
import com.shukla.umang.repository.CartItemRepository;
import com.shukla.umang.repository.UserRepository;
import com.shukla.umang.repository.CartRepository;
import com.shukla.umang.service.CartService;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ItemServiceImpl itemServiceImpl;


    public Cart addToCart(Long userId, AddToCartRequest addToCartRequest) {
        Item item = itemServiceImpl.verifyItem(addToCartRequest.getItemId());
        CartItem cartItem = new CartItem(item);
        cartItem.setQuantity(addToCartRequest.getQuantity());
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            User user = userRepository.findOne(userId);
            cart = new Cart(user);
        }
        cart.addToCart(cartItem);
        cartRepository.save(cart);
        cartItemRepository.save(cartItem);
        return cart;
    }


}
