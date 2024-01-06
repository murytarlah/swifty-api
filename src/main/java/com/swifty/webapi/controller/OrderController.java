package com.swifty.webapi.controller;

import com.swifty.webapi.dto.ApiResponse;
import com.swifty.webapi.service.order.OrderService;
import lombok.AllArgsConstructor;
import com.swifty.webapi.dto.OrderRequestDTO;
import com.swifty.webapi.dto.OrderResponseDTO;
import com.swifty.webapi.model.Order;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ApiResponse<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO createdOrder = orderService.createOrder(orderRequestDTO);
        return new ApiResponse<>( HttpStatus.OK.value(), "order created successfully", createdOrder);
    }


    @GetMapping
    public ApiResponse<List<OrderResponseDTO>> getAllOrders() {

        return new ApiResponse<>(HttpStatus.OK.value(), "");
    }

    @GetMapping("/{id}")
    public ApiResponse<Order> getOrder(@PathVariable Long id) {
        Order order = orderService.getOrder(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "order fetched successfully", order);
    }
}
