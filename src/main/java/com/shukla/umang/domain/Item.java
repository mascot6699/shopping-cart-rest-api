package com.shukla.umang.domain;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;


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

    @Column(name = "PRICE")
    @DecimalMin("0")
    private BigDecimal price;

    public Item() {
    }

    public Item(BigDecimal price, String description, String name) {
        this();
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getName();
    }
}
