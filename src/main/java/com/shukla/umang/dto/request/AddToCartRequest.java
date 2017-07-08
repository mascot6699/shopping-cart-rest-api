package com.shukla.umang.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@ApiModel(description = "Add an item to cart request DTO")
public class AddToCartRequest {

    @NotNull(message = "{addToCartRequest.productId.notnull}")
    @ApiModelProperty(name = "item_id", value = "item id of Item to be added to cart")
    @JsonProperty(value = "item_id", required = true)
    private Long itemId;

    @Min(1)
    @ApiModelProperty(name = "quantity", value = "Quantity of item to be added")
    @JsonProperty(value = "quantity", required = true)
    private int quantity;

    public AddToCartRequest() {

    }

    public AddToCartRequest(Long itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Long getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
