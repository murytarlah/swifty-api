package com.swifty.webapi.service;

import org.springframework.stereotype.Service;
import lombok.*;
import com.swifty.webapi.repository.OrderRepository;
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

    public Object createOrder(OrderRequestDTO orderDTO) {
        // Get Customer
        Customer customer = customerService.getCustomer(orderDTO.getCustomerId());

        // Create Order
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(orderDTO.getProducts().stream().mapToDouble(OrderItemDTO::getSubtotal).sum());
        
        Order savedOrder = orderRepository.save(order);
        
        order.setCustomer(customer);
        // Create Order Items
        ArrayList<OrderItem> orderItems = createOrderItems(orderDTO.getProducts(), savedOrder);

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setCustomerId(customer.getId());
        orderResponseDTO.setOrderDate(LocalDateTime.now());
        orderResponseDTO.setTotalAmount(savedOrder.getTotalAmount());
        orderResponseDTO.setOrderItems(orderItems);


        return orderResponseDTO;
    }

    public ArrayList<OrderItem> createOrderItems(ArrayList<OrderItemDTO> orderItemDTOs, Order order) {
        
        List<OrderItem> orderItems = orderItemDTOs.stream().map((OrderItemDTO orderItemDTO) -> {
            Product product = productService.getProductById(orderItemDTO.getProductId());
            return orderItemService.createOrderItem(orderItemDTO, product, order);
        }).collect(Collectors.toList());

        ArrayList<OrderItem> savedOrderItems = new ArrayList<>(orderItems);

        return savedOrderItems;

    }
        
}

