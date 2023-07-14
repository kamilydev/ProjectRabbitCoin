package com.api.RabbitCoin.controllers;

import com.api.RabbitCoin.dtos.request.UsersRequestDTO;
import com.api.RabbitCoin.dtos.response.UsersResponseDTO;
import com.api.RabbitCoin.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/users-json")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping(value = "/{id_user}")
    public ResponseEntity<UsersResponseDTO> findById(@PathVariable(name = "id_user") Long id_user) {
        return ResponseEntity.ok().body(usersService.findById(id_user));
    }

    @GetMapping
    public  ResponseEntity<List<UsersResponseDTO>> findAll(){
        return ResponseEntity.ok().body(usersService.findAll());
    }

    @PostMapping
    public ResponseEntity<UsersResponseDTO> registerUser(@RequestBody UsersRequestDTO usersRequestDTO, UriComponentsBuilder uriBuilder){
        UsersResponseDTO usersResponseDTO = usersService.registerUser(usersRequestDTO);

        URI uri = uriBuilder.path("/users-json/{id_user}").buildAndExpand(usersResponseDTO.getId_user()).toUri();
        return ResponseEntity.created(uri).body(usersResponseDTO)
                ;
    }

    @PutMapping(value = "/{id_user}")
    public ResponseEntity<UsersResponseDTO> update(@RequestBody UsersRequestDTO usersDTO, @PathVariable(name = "id_user") Long id_user){
        return ResponseEntity.ok().body(usersService.update(id_user,usersDTO));
    }

    @DeleteMapping(value = "/{id_user}")
    public ResponseEntity<String> delete(@PathVariable(value= "id_user") Long id_user){
        return ResponseEntity.ok().body(usersService.delete(id_user));
    }

}

