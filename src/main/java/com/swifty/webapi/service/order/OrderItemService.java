package com.swifty.webapi.service.order;


import com.swifty.webapi.service.product.ProductService;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;
import com.swifty.webapi.repository.OrderItemRepository;
import com.swifty.webapi.dto.OrderItemDTO;
import com.swifty.webapi.model.OrderItem;
import com.swifty.webapi.model.Product;

import lombok.*;

@Service
@AllArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;

    public OrderItem createOrderItem(OrderItemDTO orderItem) {
        Product product = productService.getProductById(orderItem.getProductId());

        double subTotal = product.getPrice() * orderItem.getQuantity();
        OrderItem newOrderItem = new OrderItem();

        newOrderItem.setProduct(product);
        newOrderItem.setSubtotal(subTotal);
        newOrderItem.setQuantity(orderItem.getQuantity());

        return orderItemRepository.save(newOrderItem);
    }
}

