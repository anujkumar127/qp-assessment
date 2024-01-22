package com.questionpro.grocerybooking.controller;

import com.questionpro.grocerybooking.entities.GroceryItem;
import com.questionpro.grocerybooking.service.GroceryItemService;
import com.questionpro.grocerybooking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    GroceryItemService groceryItemService;

    @Autowired
    OrderService orderService;
    @GetMapping("viewAvailableGroceryItems")
    public List<GroceryItem> viewGroceryItem(){
        return groceryItemService.viewAvailableGroceryItems();
    }

    @PostMapping("placeOrder")
    public void placeOrder(@RequestBody Map<String, List<Long>> request){
        List<Long> ids = request.get("ids");
        orderService.placeOrder(ids);
    }
}
