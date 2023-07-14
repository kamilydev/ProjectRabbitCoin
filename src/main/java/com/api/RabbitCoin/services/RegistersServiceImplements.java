package com.api.RabbitCoin.services;

import com.api.RabbitCoin.dtos.request.RegistersRequestDTO;
import com.api.RabbitCoin.dtos.response.RegistersResponseDTO;
import com.api.RabbitCoin.models.RegistersModel;
import com.api.RabbitCoin.models.UsersModel;
import com.api.RabbitCoin.repositories.RegistersRepository;
import com.api.RabbitCoin.repositories.UsersRepository;
import com.api.RabbitCoin.util.RegistersMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class RegistersServiceImplements implements RegistersService {

    private final RegistersRepository registersRepository;
    private final UsersRepository usersRepository;
    private final RegistersMapper registersMapper;

    @Override
    public RegistersResponseDTO findById(Long id_user,Long id_register) {
        RegistersModel register = returnRegister(id_register);
        validateUserAccess(id_user, register.getUsersModel());
        return registersMapper.toRegisterDTO(register);
    }

    @Override
    public List<RegistersResponseDTO> findAllByUser(Long id_user) {
        Optional<UsersModel> user = usersRepository.findById(id_user);
        if (user.isPresent()) {
            List<RegistersModel> registers = user.get().getRegisters();
            return registers.stream()
                    .map(registersMapper::toRegisterDTO)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public RegistersResponseDTO insertRegister(Long id_user, RegistersRequestDTO registerDTO) {
        Optional<UsersModel> user = usersRepository.findById(id_user);
        if (user.isPresent()) {
            RegistersModel registersModel = registersMapper.toRegister(user.get().getId_user(), registerDTO);
            RegistersModel savedRegister = registersRepository.save(registersModel);
            return registersMapper.toRegisterDTO(savedRegister);
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    @Override
    public RegistersResponseDTO updateRegister(Long id_user, Long id_register, RegistersRequestDTO registerDTO) {
        RegistersModel register = returnRegister(id_register);
        validateUserAccess(id_user, register.getUsersModel());
        registersMapper.updateRegister(register, registerDTO);
        RegistersModel updatedRegister = registersRepository.save(register);
        return registersMapper.toRegisterDTO(updatedRegister);
    }
    @Override
    public String deleteRegister(Long id_user, Long id_register) {
        RegistersModel register = returnRegister(id_register);
        validateUserAccess(id_user, register.getUsersModel());
        registersRepository.deleteById(id_register);
        return "Registro " + id_register + " deletado";
    }


    private RegistersModel returnRegister(Long id_register) {
        return registersRepository.findById(id_register)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    private void validateUserAccess(Long id_user, UsersModel user) {
        if (!user.getId_user().equals(id_user)) {
            throw new RuntimeException("Acesso não autorizado");
        }
    }
}