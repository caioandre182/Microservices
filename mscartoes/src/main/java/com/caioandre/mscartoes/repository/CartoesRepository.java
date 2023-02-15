package com.caioandre.mscartoes.repository;

import com.caioandre.mscartoes.model.Cartoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CartoesRepository extends JpaRepository<Cartoes, Long> {
    List<Cartoes> findByIncomeLessThanEqual(BigDecimal incomeBigDecimal);
}
