package com.swifty.webapi.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
}
