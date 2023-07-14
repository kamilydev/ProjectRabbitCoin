package com.api.RabbitCoin.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistersRequestDTO{
    private String day;

    private String type;

    private String description;

    private Double price;

    private String category;

}






