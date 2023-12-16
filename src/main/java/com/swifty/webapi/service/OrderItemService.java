package com.swifty.webapi.service;


import org.springframework.stereotype.Service;

import jakarta.persistence.*;
import com.swifty.webapi.repository.OrderItemRepository;
import com.swifty.webapi.dto.OrderItemDTO;
import com.swifty.webapi.model.Order;
import com.swifty.webapi.model.OrderItem;
import com.swifty.webapi.model.Product;

import lombok.*;

@Service
@AllArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItem createOrderItem(OrderItemDTO orderItemDTO, Product product, Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setSubtotal(orderItemDTO.getSubtotal());

        return orderItemRepository.save(orderItem);
    }
}

