package com.swifty.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swifty.webapi.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
