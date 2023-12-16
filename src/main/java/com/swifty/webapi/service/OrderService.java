package com.swifty.webapi.service;

import com.swifty.webapi.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import lombok.*;
import com.swifty.webapi.repository.OrderRepository;

import jakarta.transaction.Transactional;

import com.swifty.webapi.dto.OrderRequestDTO;
import com.swifty.webapi.dto.OrderResponseDTO;
import com.swifty.webapi.model.Order;
import com.swifty.webapi.model.Customer;
import com.swifty.webapi.dto.OrderItemDTO;
import com.swifty.webapi.model.OrderItem;
import com.swifty.webapi.model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderItemRepository orderItemRepository;

    public OrderResponseDTO createOrder(OrderRequestDTO orderDTO) {
        // Get Customer
        Customer customer = customerService.getCustomer(orderDTO.getCustomerId());
        List<OrderItem> orderItems = new ArrayList<>();
        orderDTO.getProducts().forEach(orderItem -> {
            Product product = productService.getProductById(orderItem.getProductId());

            double subTotal = product.getPrice() * orderItem.getQuantity();
            OrderItem newOrderItem = new OrderItem();

            newOrderItem.setProduct(product);
            newOrderItem.setSubtotal(subTotal);
            newOrderItem.setQuantity(orderItem.getQuantity());

            OrderItem saved = orderItemRepository.save(newOrderItem);

            orderItems.add(saved);
        });
        double sum = orderItems.stream().mapToDouble(OrderItem::getSubtotal).sum();
        // Create Order
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(sum);
        order.setCustomer(customer);
        order.getOrderItems().addAll(orderItems);

        Order savedOrder = orderRepository.save(order);

        // Create Order Items
//        ArrayList<OrderItem> orderItems = createOrderItems(orderDTO.getProducts(), savedOrder);

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setCustomerId(customer.getId());
        orderResponseDTO.setOrderDate(savedOrder.getOrderDate());
        orderResponseDTO.setTotalAmount(savedOrder.getTotalAmount());
        orderResponseDTO.setOrderItems(orderItems);

        return orderResponseDTO;
    }
}
