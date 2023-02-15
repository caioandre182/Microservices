package com.caioandre.mscartoes.services;


import com.caioandre.mscartoes.model.ClientCartoes;
import com.caioandre.mscartoes.repository.ClientCartoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCartoesService {

    private final ClientCartoesRepository repository;

    public List<ClientCartoes> listCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
