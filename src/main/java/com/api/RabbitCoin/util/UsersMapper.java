package com.api.RabbitCoin.util;

import com.api.RabbitCoin.dtos.request.UsersRequestDTO;
import com.api.RabbitCoin.dtos.response.UsersResponseDTO;
import com.api.RabbitCoin.models.UsersModel;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersMapper {
    public UsersModel toUser(UsersRequestDTO userDTO){
        return UsersModel.builder()
                .name(userDTO.getName())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .build();
    }
    public UsersResponseDTO toUserDTO(UsersModel users){
        return new UsersResponseDTO(users);
    }

    public List<UsersResponseDTO> toUserDTO(List<UsersModel> usersModelList){
        return usersModelList.stream().map(UsersResponseDTO::new).collect(Collectors.toList());
    }

    public void updateUserData(UsersModel usersModel,UsersRequestDTO userDTO){
        usersModel.setName(userDTO.getName());
        usersModel.setUsername(userDTO.getUsername());
        usersModel.setPassword(userDTO.getPassword());
        usersModel.setEmail(userDTO.getEmail());

    }
}
