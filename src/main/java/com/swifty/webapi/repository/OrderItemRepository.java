package com.swifty.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swifty.webapi.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
