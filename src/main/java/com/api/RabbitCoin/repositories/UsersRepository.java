package com.api.RabbitCoin.repositories;

import com.api.RabbitCoin.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Long> {
    Optional<UsersModel> findByUsernameAndPassword(String username);

}
