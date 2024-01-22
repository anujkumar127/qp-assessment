package com.questionpro.grocerybooking.repository;

import com.questionpro.grocerybooking.entities.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

    @Modifying
    @Transactional
    @Query("update GroceryItem G set G.inventory = :inventory where G.id = :id")
    void updateInventoryByID(Long id, int inventory);
}

