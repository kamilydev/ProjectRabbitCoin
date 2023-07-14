package com.api.RabbitCoin.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsersRequestDTO {

    private String name;

    private String username;

    private String password;

    private String email;
}
