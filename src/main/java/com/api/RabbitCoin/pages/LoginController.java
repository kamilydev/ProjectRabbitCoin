package com.api.RabbitCoin.pages;

import com.api.RabbitCoin.dtos.request.UsersRequestDTO;
import com.api.RabbitCoin.dtos.response.UsersResponseDTO;
import com.api.RabbitCoin.models.UsersModel;
import com.api.RabbitCoin.repositories.UsersRepository;
import com.api.RabbitCoin.services.UsersService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UsersService usersService;

    @GetMapping(value = "/login")
    public String form(){
        return "Home/home";
    }

    @PostMapping(value = "/newUser")
    public void registerUser() {
    }

}
