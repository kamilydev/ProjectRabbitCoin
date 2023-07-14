package com.api.RabbitCoin.dtos.response;

import com.api.RabbitCoin.models.UsersModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsersResponseDTO {
    private Long id_user;

    private String name;

    private String username;

    private String password;

    private String email;

    public UsersResponseDTO(UsersModel user){
        this.id_user = user.getId_user();
        this.name = user.getName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();

    }


}
