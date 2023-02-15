package com.caioandre.mscartoes.repository;

import com.caioandre.mscartoes.model.ClientCartoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientCartoesRepository extends JpaRepository<ClientCartoes, Long> {
    List<ClientCartoes> findByCpf(String cpf);
}
