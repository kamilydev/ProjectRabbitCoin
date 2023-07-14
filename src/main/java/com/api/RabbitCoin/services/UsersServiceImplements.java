package com.api.RabbitCoin.services;

import com.api.RabbitCoin.dtos.request.UsersRequestDTO;
import com.api.RabbitCoin.dtos.response.UsersResponseDTO;
import com.api.RabbitCoin.models.UsersModel;
import com.api.RabbitCoin.repositories.UsersRepository;
import com.api.RabbitCoin.util.UsersMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class UsersServiceImplements implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UsersResponseDTO findById(Long id_user) {
        return usersMapper.toUserDTO(returnUser(id_user));
    }

    @Override
    public List<UsersResponseDTO> findAll() {
        return usersMapper.toUserDTO(usersRepository.findAll());
    }

    @Override
    public UsersResponseDTO registerUser(UsersRequestDTO userDTO) {
        UsersModel usersModel = usersMapper.toUser(userDTO);
        return usersMapper.toUserDTO(usersRepository.save(usersModel));
    }


    @Override
    public UsersResponseDTO update(Long id_user, UsersRequestDTO userDTO) {
        UsersModel user = returnUser(id_user);
        usersMapper.updateUserData(user,userDTO);
        return usersMapper.toUserDTO(usersRepository.save(user));
    }

    @Override
    public String delete(Long id_user) {
        usersRepository.deleteById(id_user);
        return "Usuário: " + id_user + " deletado";
    }

    private UsersModel returnUser(Long id_user){
        return usersRepository.findById(id_user)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
    }
}
