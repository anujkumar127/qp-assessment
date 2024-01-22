package com.questionpro.grocerybooking.service;

import com.questionpro.grocerybooking.entities.GroceryItem;
import com.questionpro.grocerybooking.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroceryItemService {

    @Autowired
    GroceryItemRepository groceryItemRepository;
    public void addGroceryItem(GroceryItem groceryItem) {
        groceryItemRepository.save(groceryItem);
    }

    public List<GroceryItem> viewGroceryItem() {
        return groceryItemRepository.findAll();
    }

    public void removeGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
    }

    public void updateGroceryItem(GroceryItem groceryItem) {
        groceryItemRepository.save(groceryItem);
    }


    public void updateInventory(Long id, int inventory) {
        groceryItemRepository.updateInventoryByID(id, inventory);
    }

    public List<GroceryItem> viewAvailableGroceryItems() {
        List<GroceryItem> groceryItems = groceryItemRepository.findAll();
        List<GroceryItem> availableGroceryItems = new ArrayList<>() ;
        for (GroceryItem groceryItem : groceryItems){
            if(groceryItem.getInventory() > 0){
                availableGroceryItems.add(groceryItem);
            }
        }
        return availableGroceryItems;

    }
}
