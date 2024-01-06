package com.swifty.webapi.service.order;


import com.swifty.webapi.dto.OrderItemRequestDTO;
import com.swifty.webapi.model.Order;
import com.swifty.webapi.service.product.ProductService;
import org.springframework.stereotype.Service;

import com.swifty.webapi.repository.OrderItemRepository;
import com.swifty.webapi.dto.OrderItemDTO;
import com.swifty.webapi.model.OrderItem;
import com.swifty.webapi.model.Product;

import lombok.*;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;

    public OrderItem createOrderItem(OrderItemRequestDTO orderItem, Order order) {
        Product product = productService.getProduct(orderItem.getProductId());

        double subTotal = product.getPrice() * orderItem.getQuantity();
        OrderItem newOrderItem = new OrderItem();

        newOrderItem.setProduct(product);
        newOrderItem.setOrder(order);
        newOrderItem.setSubtotal(subTotal);
        newOrderItem.setQuantity(orderItem.getQuantity());

        return orderItemRepository.save(newOrderItem);
    }
}

