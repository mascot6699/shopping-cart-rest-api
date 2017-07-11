package com.shukla.umang.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Entity
@Table
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="cart_id")
    private Map<Long, CartItem> cartItems;

    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Min(0)
    private BigDecimal totalCost;

    public Cart() {
        cartItems = new HashMap<>();
        totalCost = new BigDecimal(0);
    }

    public Cart(User user) {
        this();
        //this.cartId = cartId;
        this.user = user;
    }

    public Map<Long, CartItem> getCartItems() {
        return cartItems;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void addToCart(CartItem newItem) {
        Long productId = newItem.getItem().getId();
        if (cartItems.containsKey(productId)) {
            CartItem item = cartItems.get(productId);
            item.setQuantity(item.getQuantity() + newItem.getQuantity());
            cartItems.put(productId, item);
        } else {
            cartItems.put(productId, newItem);
        }
        updateTotalCost();
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public void setCartItems(Map<Long, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void updateTotalCost() {
        totalCost = new BigDecimal(0);

        for (CartItem cartItem : cartItems.values()) {
            this.totalCost = this.totalCost.add(cartItem.getTotalPrice());
        }
    }

    public Long getCartId() {
        return cartId;
    }

    public User getUser() {
        return user;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
