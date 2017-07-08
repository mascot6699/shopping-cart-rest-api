package com.shukla.umang.domain;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="CART_ITEM")
public class CartItem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long cartItemId;

    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
    @JoinColumn(name = "item_id")
    private Item item;

    @NotNull
    @Min(1)
    private int quantity;

    @NotNull
    @DecimalMin("0")
    private BigDecimal totalPrice;

    public CartItem() {}

    public CartItem(Item item)
    {
        this.item = item;
        this.quantity = 1;
        this.totalPrice = item.getPrice();
    }

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
        this.updateTotalPrice();
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
        this.updateTotalPrice();
    }

    public BigDecimal getTotalPrice()
    {
        return totalPrice;
    }

    private void updateTotalPrice()
    {
        totalPrice = this.item.getPrice().multiply(new BigDecimal(this.quantity));
    }
}
