package com.swifty.webapi.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import lombok.*;

import com.swifty.webapi.model.OrderItem;

@Data
@AllArgsConstructor @NoArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private Long customerId;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private ArrayList<OrderItem> orderItems;
}
