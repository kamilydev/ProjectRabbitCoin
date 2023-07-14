package com.api.RabbitCoin.models;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name= "users")
public class UsersModel implements Serializable {

    @Id
    @SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @Setter(AccessLevel.NONE)
    private Long id_user;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    //RELACIONAMENTO ENTRE TABELAS
    @OneToMany(mappedBy = "usersModel")
    private List<RegistersModel> registers;


    @Builder
    public UsersModel(Long id_user, String name, String username, String password, String email) {
        this.id_user = id_user;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
