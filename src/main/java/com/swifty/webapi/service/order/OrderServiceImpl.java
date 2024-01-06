package com.swifty.webapi.service.order;

import com.swifty.webapi.service.user.UserService;
import org.springframework.stereotype.Service;
import lombok.*;
import com.swifty.webapi.repository.OrderRepository;

import com.swifty.webapi.dto.OrderRequestDTO;
import com.swifty.webapi.dto.OrderResponseDTO;
import com.swifty.webapi.model.Order;
import com.swifty.webapi.model.User;
import com.swifty.webapi.model.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final OrderItemServiceImpl orderItemService;
    private final UserService userService;

    public OrderResponseDTO createOrder(OrderRequestDTO orderDTO) {
        // Create Order
        Order order = new Order();

        // Get user
        User user = userService.getUser(orderDTO.getCustomerId());

        // create list to store order-items for order
        List<OrderItem> orderItems = new ArrayList<>();
        orderDTO.getProducts().forEach(orderItem -> {
            // create order-item
            OrderItem savedItem = orderItemService.createOrderItem(orderItem, order);

            // add order-item to list of order-items
            orderItems.add(savedItem);
        });
        // calculate the total amount for the order
        double sum = orderItems.stream().mapToDouble(OrderItem::getSubtotal).sum();

        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(sum);
        order.setUser(user);
//        order.getOrderItems().addAll(orderItems);
        order.setOrderItems(orderItems);


        Order savedOrder = orderRepository.save(order);

        // create order response object and return it
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setCustomerId(user.getId());
        orderResponseDTO.setOrderDate(savedOrder.getOrderDate());
        orderResponseDTO.setTotalAmount(savedOrder.getTotalAmount());
        orderResponseDTO.setOrderItems(savedOrder.getOrderItems());

        return orderResponseDTO;
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
