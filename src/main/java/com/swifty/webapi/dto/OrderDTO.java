package com.swifty.webapi.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

import com.swifty.webapi.model.OrderItem;

@Data
@NoArgsConstructor
public class OrderDTO {
	private Long id;
	private LocalDateTime orderDate;
	private Double totalAmount;
	private List<OrderItemDTO> orderItems;
}
