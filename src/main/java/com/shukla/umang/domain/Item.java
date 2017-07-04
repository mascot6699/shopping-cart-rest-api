package com.shukla.umang.domain;

import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * This class consists exclusively of non-static methods that return
 * properties of item. It is mapped with Item table in database.
 */
@Entity
@Table(name="ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    @NotEmpty
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name = "QUANTITY")
    @NotEmpty
    private Integer quantity;

    @Column(name = "PRICE")
    @NotEmpty
    private Double price;

    public Item(){

    }

    public Item(Double price, Integer quantity, String description, String name) {
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.name = name;
    }

    /**
     * Getters for Item class.
     */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Setters for Item class.
     */

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getName();
    }
}