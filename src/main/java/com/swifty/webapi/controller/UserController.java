package com.swifty.webapi.controller;

import com.swifty.webapi.dto.ApiResponse;
import com.swifty.webapi.model.Order;
import com.swifty.webapi.service.user.UserService;
import lombok.AllArgsConstructor;
import com.swifty.webapi.dto.UserDTO;
import com.swifty.webapi.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ApiResponse<User> createUser(@RequestBody UserDTO userDTO) {
        User createdUser = userService.createUser(userDTO);
        return new ApiResponse<>(HttpStatus.OK.value(), "user created successfully", createdUser);
    }

    @GetMapping
    public ApiResponse<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ApiResponse<>(HttpStatus.OK.value(),"users fetched successfully",users);
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getUser(@PathVariable Long id){
        User user = userService.getUser(id);

        return new ApiResponse<>( HttpStatus.OK.value(), "user fetched successfully", user);
    }

    @GetMapping("/{id}/orders")
    public ApiResponse<List<Order>> getUserOrders(@PathVariable Long id){
        List<Order> userOrders = userService.getUserOrders(id);

        return new ApiResponse<>( HttpStatus.OK.value(), "user orders fetched successfully", userOrders);
    }

    @PutMapping("/{id}")
    public  ApiResponse<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        User user = userService.updateUser(userDTO, id);

        return new ApiResponse<>(HttpStatus.OK.value(), "user deleted successfully", user);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<User> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "user deleted successfully", null);
    }
}
