package com.questionpro.grocerybooking.service;

import com.questionpro.grocerybooking.entities.GroceryItem;
import com.questionpro.grocerybooking.entities.Order;
import com.questionpro.grocerybooking.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    GroceryItemService groceryItemService;

    @Autowired
    OrderRepository orderRepository;
    public void placeOrder(List<Long> ids) {

        Order order = new Order();
        List<GroceryItem> availableGroceryItems = groceryItemService.viewAvailableGroceryItems();

        for (GroceryItem groceryItem : availableGroceryItems) {
            for (Long id : ids) {
                if (groceryItem.getId().equals(id)) {
                    order.getGroceryItemList().add(groceryItem);
                }
            }
        }
        orderRepository.save(order);


    }
}
