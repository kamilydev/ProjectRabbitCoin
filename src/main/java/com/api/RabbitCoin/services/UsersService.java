package com.api.RabbitCoin.services;

import com.api.RabbitCoin.dtos.request.UsersRequestDTO;
import com.api.RabbitCoin.dtos.response.UsersResponseDTO;

import java.util.List;

public interface UsersService {
    UsersResponseDTO findById(Long id_user);


    List<UsersResponseDTO> findAll();

    UsersResponseDTO registerUser(UsersRequestDTO userDTO);

    UsersResponseDTO update(Long id_user,UsersRequestDTO userDTO);

    String delete(Long id_user);
}