package com.questionpro.grocerybooking.controller;

import com.questionpro.grocerybooking.entities.GroceryItem;
import com.questionpro.grocerybooking.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    GroceryItemService groceryItemService;
    @PostMapping("addGroceryItem")
    public void addGroceryItem(@RequestBody GroceryItem groceryItem){
        groceryItemService.addGroceryItem(groceryItem);
    }
    @GetMapping("viewGroceryItems")
    public List<GroceryItem> viewGroceryItem(){
        return groceryItemService.viewGroceryItem();
    }
    @DeleteMapping("removeGroceryItem/{id}")
    public void removeGroceryitem(@PathVariable Long id){
        groceryItemService.removeGroceryItem(id);
    }


    @PutMapping("updateGroceryItem")
    public void updateGroceryitem(@RequestBody GroceryItem groceryItem){
        groceryItemService.updateGroceryItem(groceryItem);
    }

    @PutMapping("updateInventoryLevel/{id}/{inventory}")
    public void updateGroceryitem(@PathVariable Long id,@PathVariable int inventory){
        groceryItemService.updateInventory(id,inventory);
    }
}
