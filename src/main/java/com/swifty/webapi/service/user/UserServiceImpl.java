package com.swifty.webapi.service.user;


import com.swifty.webapi.dto.ApiResponse;
import com.swifty.webapi.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import com.swifty.webapi.repository.UserRepository;
import com.swifty.webapi.model.User;
import com.swifty.webapi.dto.UserDTO;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public User createUser(UserDTO userDTO) {

        User user = new User();

        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());

        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ApiResponse<>(HttpStatus"user does not exist"));
    }

    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public User updateUser(UserDTO userDTO, Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());

        return userRepository.save(user);
    }

    public User deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return user;
    }

}
