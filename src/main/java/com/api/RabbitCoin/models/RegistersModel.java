package com.api.RabbitCoin.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name= "registers")
public class RegistersModel {

    @Id
    @SequenceGenerator(name = "registers_sequence", sequenceName = "registers_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registers_sequence")
    private Long id_register;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false, length = 7)
    private String type;

    @Column(nullable = false, length = 50)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, length = 20)
    private String category;


    //RELACIONAMENTOS ENTRE TABELAS
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user", nullable = false)
    private UsersModel usersModel;

    @Builder
    public RegistersModel(Long id_register, String day, String description, Double price, String category, String type) {
        this.id_register = id_register;
        this.day = day;
        this.description = description;
        this.type = type;
        this.price = price;
        this.category = category;
    }

}

