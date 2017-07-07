package com.shukla.umang.domain;

import javax.persistence.*;

import com.shukla.umang.domain.enums.ItemRating;
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

    @Column(name = "RATING")
    @Enumerated(EnumType.STRING)
    @NotEmpty
    private ItemRating rating;

    @Column(name = "PRICE")
    @NotEmpty
    private Double price;

    public Item() {
        this.rating = ItemRating.NO_RATING;
    }

    public Item(Double price, ItemRating rating, String description, String name) {
        this();
        this.price = price;
        this.rating = rating;
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

    public ItemRating getRating() {
        return rating;
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

    public void setRating(ItemRating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return getName();
    }
}
