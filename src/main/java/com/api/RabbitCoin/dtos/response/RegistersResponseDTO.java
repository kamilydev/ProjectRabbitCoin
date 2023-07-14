package com.api.RabbitCoin.dtos.response;

import com.api.RabbitCoin.models.RegistersModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistersResponseDTO {
    private Long id_register;

    private String day;

    private String type;

    private String description;

    private Double price;

    private String category;

    public RegistersResponseDTO(RegistersModel register){
        this.id_register = register.getId_register();
        this.day = register.getDay();
        this.type = register.getType();
        this.description = register.getDescription();
        this.price = register.getPrice ();
        this.category = register.getCategory();

    }
}

