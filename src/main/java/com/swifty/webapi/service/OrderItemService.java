package com.swifty.webapi.service;


import org.springframework.stereotype.Service;

import com.swifty.webapi.repository.OrderItemRepository;
import com.swifty.webapi.dto.OrderItemDTO;
import com.swifty.webapi.model.Order;
import com.swifty.webapi.model.OrderItem;
import com.swifty.webapi.model.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    // private final ProductService productService;
    // private final OrderService orderService;

    public OrderItem createOrderItem(OrderItemDTO orderItemDTO, Product product, Order order) {
        // Retrieve order details
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setSubtotal(product.getPrice() * orderItemDTO.getQuantity());
        return orderItemRepository.save(orderItem);
    }

}

