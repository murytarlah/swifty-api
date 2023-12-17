package com.swifty.webapi.service.order;

import com.swifty.webapi.dto.OrderRequestDTO;
import com.swifty.webapi.dto.OrderResponseDTO;
import com.swifty.webapi.model.Order;
import com.swifty.webapi.model.OrderItem;
import com.swifty.webapi.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface OrderService {
	public OrderResponseDTO createOrder(OrderRequestDTO orderDTO);
}
