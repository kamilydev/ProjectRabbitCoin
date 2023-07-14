package com.api.RabbitCoin.util;

import com.api.RabbitCoin.dtos.request.RegistersRequestDTO;
import com.api.RabbitCoin.dtos.response.RegistersResponseDTO;
import com.api.RabbitCoin.models.RegistersModel;
import com.api.RabbitCoin.models.UsersModel;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegistersMapper {
    public RegistersModel toRegister(Long id_user, RegistersRequestDTO registerDTO) {
        UsersModel user = new UsersModel();
        user.setId_user(id_user);

        RegistersModel registersModel = RegistersModel.builder()
                .day(registerDTO.getDay())
                .type(registerDTO.getType())
                .description(registerDTO.getDescription())
                .price(registerDTO.getPrice())
                .category(registerDTO.getCategory())
                .build();

        registersModel.setUsersModel(user);

        return registersModel;
    }

    public RegistersResponseDTO toRegisterDTO(RegistersModel registers) {
        return new RegistersResponseDTO(registers);
    }

    public List<RegistersResponseDTO> toRegisterDTOList(List<RegistersModel> registersModelList) {
        return registersModelList.stream()
                .map(this::toRegisterDTO)
                .collect(Collectors.toList());
    }

    public void updateRegister(RegistersModel registersModel, RegistersRequestDTO registerDTO) {
        registersModel.setDay(registerDTO.getDay());
        registersModel.setType(registerDTO.getType());
        registersModel.setPrice(registerDTO.getPrice());
        registersModel.setCategory(registerDTO.getCategory());
        registersModel.setDescription(registerDTO.getDescription());
    }
}