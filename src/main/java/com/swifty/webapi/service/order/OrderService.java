package com.swifty.webapi.service.order;

import com.swifty.webapi.dto.OrderRequestDTO;
import com.swifty.webapi.model.Order;
import com.swifty.webapi.dto.OrderResponseDTO;

public interface OrderService {
	OrderResponseDTO createOrder(OrderRequestDTO orderDTO);

	Order getOrder(Long orderId);

}
