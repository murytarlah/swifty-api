package com.swifty.webapi.service.user;

import com.swifty.webapi.dto.UserDTO;
import com.swifty.webapi.model.User;

import java.util.ArrayList;

public interface UserService {
	public User createUser(UserDTO userDTO);

	public User getUser(Long id);

	public ArrayList<User> getAllUsers();

	public User updateUser(UserDTO userDTO, Long id);

	public User deleteUser(Long id);
}
