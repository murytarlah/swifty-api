package com.swifty.webapi.controller;

import com.swifty.webapi.dto.ApiResponse;
import com.swifty.webapi.service.user.UserService;
import lombok.AllArgsConstructor;
import com.swifty.webapi.dto.UserDTO;
import com.swifty.webapi.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return new ApiResponse<>(HttpStatus.CREATED.value(), "user created successfully", createdUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userService.getUser(id);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
