package com.api.RabbitCoin.repositories;

import com.api.RabbitCoin.models.RegistersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegistersRepository extends JpaRepository<RegistersModel, Long> {

}
