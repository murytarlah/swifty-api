package com.swifty.webapi.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequestDTO {
	@NonNull private Long productId;
	@NonNull private Integer quantity;
}
