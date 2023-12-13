package com.swifty.webapi.dto;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderItemDTO {
    @NonNull private Long productId;
    @NonNull private Integer quantity;
    private Double subtotal;
}
