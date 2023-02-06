package com.caioandre.msclients.repository;

import com.caioandre.msclients.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
