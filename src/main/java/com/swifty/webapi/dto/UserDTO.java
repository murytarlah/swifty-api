package com.swifty.webapi.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
}
