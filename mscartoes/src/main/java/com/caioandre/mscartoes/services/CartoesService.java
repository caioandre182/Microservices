package com.caioandre.mscartoes.services;

import com.caioandre.mscartoes.model.Cartoes;
import com.caioandre.mscartoes.repository.CartoesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartoesService {

    private final CartoesRepository repository;

    @Transactional
    public Cartoes save(Cartoes cartoes){
        return repository.save(cartoes);
    }

    public List<Cartoes> getCartoesIncomeLessThanEqual(Long income){
        var incomeBigDecimal = BigDecimal.valueOf(income);
        return repository.findByIncomeLessThanEqual(incomeBigDecimal);
    }
}
