package com.swifty.webapi.service.user;


import com.swifty.webapi.exception.UserException;
import com.swifty.webapi.model.Order;
import com.swifty.webapi.service.order.OrderService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;
import com.swifty.webapi.repository.UserRepository;
import com.swifty.webapi.model.User;
import com.swifty.webapi.dto.UserDTO;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User createUser(UserDTO userDTO) {

        User user = new User();

        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());

        return userRepository.save(user);
    }
    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
	    return userRepository.findAll();
    }

    @Override
    public User updateUser(UserDTO userDTO, Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserException("User not found"));

        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());

        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserException("User not found"));
        userRepository.delete(user);
        return user;
    }

    @Override
    public List<Order> getUserOrders(Long id){
        User user = userRepository.findById(id).orElseThrow(()-> new UserException("user not found"));

        return user.getOrders();
    }

}
