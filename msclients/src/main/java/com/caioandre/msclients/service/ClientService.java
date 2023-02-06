package com.caioandre.msclients.service;

import com.caioandre.msclients.model.Client;
import com.caioandre.msclients.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    @Transactional
    public Client save(Client client){
        return repository.save(client);
    }

    public Optional<Client> getByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

}
