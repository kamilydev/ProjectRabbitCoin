//package com.api.RabbitCoin.pages;
//
//import com.api.RabbitCoin.dtos.request.RegistersRequestDTO;
//import com.api.RabbitCoin.dtos.response.RegistersResponseDTO;
//import com.api.RabbitCoin.services.RegistersService;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//
//@Controller
//@Transactional
//@RequestMapping(value = "/registers")
//@RequiredArgsConstructor
//public class RegistersController {
//
//    @Autowired
//    private final RegistersService registersService;
//
//    @GetMapping(value = "/users/{id_user}/registers/{id_register}")
//    public ResponseEntity<RegistersResponseDTO> findById(@PathVariable(name = "id_user") Long id_user, @PathVariable(name = "id_register") Long id_register) {
//        return ResponseEntity.ok().body(registersService.findById(id_user,id_register));
//    }
//
//    @GetMapping("/users/{id_user}/registers")
//    public ResponseEntity<List<RegistersResponseDTO>> findAllByUser(@PathVariable(name = "id_user") Long id_user) {
//        return ResponseEntity.ok().body(registersService.findAllByUser(id_user));
//    }
//
//    @PostMapping("/users/{id_user}/registers")
//    public ResponseEntity<RegistersResponseDTO> insertRegister(@PathVariable(name = "id_user") Long id_user, @RequestBody RegistersRequestDTO registersRequestDTO, UriComponentsBuilder uriBuilder) {
//        RegistersResponseDTO registersResponseDTO = registersService.insertRegister(id_user, registersRequestDTO);
//
//        URI uri = uriBuilder.path("/registers/users/{id_user}/registers/{id_register}").buildAndExpand(id_user, registersResponseDTO.getId_register()).toUri();
//        return ResponseEntity.created(uri).body(registersResponseDTO);
//    }
//
//    @PutMapping("/users/{id_user}/registers/{id_register}")
//    public ResponseEntity<RegistersResponseDTO> updateRegister(@PathVariable(name = "id_user") Long id_user, @PathVariable(name = "id_register") Long id_register, @RequestBody RegistersRequestDTO registersRequestDTO) {
//        return ResponseEntity.ok().body(registersService.updateRegister(id_user, id_register, registersRequestDTO));
//    }
//
//    @DeleteMapping("/users/{id_user}/registers/{id_register}")
//    public ResponseEntity<String> deleteRegister(@PathVariable(name = "id_user") Long id_user, @PathVariable(name = "id_register") Long id_register) {
//        return ResponseEntity.ok().body(registersService.deleteRegister(id_user, id_register));
//    }
//}
//
