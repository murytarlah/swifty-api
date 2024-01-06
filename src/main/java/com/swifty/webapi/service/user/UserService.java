package com.swifty.webapi.service.user;

import com.swifty.webapi.dto.UserDTO;
import com.swifty.webapi.model.Order;
import com.swifty.webapi.model.User;

import java.util.List;

public interface UserService {
	User createUser(UserDTO userDTO);

	User getUser(Long id);

	List<User> getAllUsers();

	User updateUser(UserDTO userDTO, Long id);

	User deleteUser(Long id);

	List<Order> getUserOrders(Long id);
}
