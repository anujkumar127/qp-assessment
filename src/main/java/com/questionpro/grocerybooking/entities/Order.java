package com.questionpro.grocerybooking.entities;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class Order {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_id", referencedColumnName = "id")
    private List<GroceryItem> groceryItemList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GroceryItem> getGroceryItemList() {
        return groceryItemList;
    }

    public void setGroceryItemList(List<GroceryItem> groceryItemList) {
        this.groceryItemList = groceryItemList;
    }
}
