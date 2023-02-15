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
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private CardBrand cardBrand;
    @Column
    private BigDecimal income;
    @Column
    private BigDecimal limitBasic;

    public Cartoes(String name, CardBrand cardBrand, BigDecimal income, BigDecimal limitBasic) {
        this.name = name;
        this.cardBrand = cardBrand;
        this.income = income;
        this.limitBasic = limitBasic;
    }
}
