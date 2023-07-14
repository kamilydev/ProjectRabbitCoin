package com.api.RabbitCoin.services;

import com.api.RabbitCoin.dtos.request.RegistersRequestDTO;
import com.api.RabbitCoin.dtos.response.RegistersResponseDTO;

import java.util.List;

public interface RegistersService {
    RegistersResponseDTO findById(Long id_user,Long id_register);

    List<RegistersResponseDTO> findAllByUser(Long id_user);

    RegistersResponseDTO insertRegister(Long id_user,RegistersRequestDTO registerDTO);

    RegistersResponseDTO updateRegister(Long id_user,Long id_register,RegistersRequestDTO registerDTO);

    String deleteRegister(Long id_user, Long id_register);
}