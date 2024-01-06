package com.swifty.webapi.service.order;

import com.swifty.webapi.dto.OrderItemRequestDTO;
import com.swifty.webapi.model.Order;
import com.swifty.webapi.model.OrderItem;

public interface OrderItemService {
	OrderItem createOrderItem(OrderItemRequestDTO orderItem, Order order);
}
