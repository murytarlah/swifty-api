package com.swifty.webapi.dto;

import lombok.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private Long customerId;
    private ArrayList<OrderItemRequestDTO> products;
}
