package com.swifty.webapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

import com.swifty.webapi.model.OrderItem;

@Data
@NoArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private Long customerId;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private List<OrderItem> orderItems;
}
