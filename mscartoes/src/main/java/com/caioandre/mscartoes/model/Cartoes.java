package com.caioandre.mscartoes.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Cartoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CardBrand cardBrand;
    private BigDecimal income;
    private BigDecimal limit;

    public Cartoes(String name, CardBrand cardBrand, BigDecimal income, BigDecimal limit) {
        this.name = name;
        this.cardBrand = cardBrand;
        this.income = income;
        this.limit = limit;
    }
}
