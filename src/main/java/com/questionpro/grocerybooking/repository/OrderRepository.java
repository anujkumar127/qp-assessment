package com.questionpro.grocerybooking.repository;

import com.questionpro.grocerybooking.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
