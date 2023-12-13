package com.swifty.webapi.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderItemDTO {
    @NonNull private Long productId;
    @NonNull private Integer quantity;
    private Double subtotal;

}
