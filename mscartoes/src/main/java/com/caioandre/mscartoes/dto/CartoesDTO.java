package com.caioandre.mscartoes.dto;


import com.caioandre.mscartoes.model.CardBrand;
import com.caioandre.mscartoes.model.Cartoes;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartoesDTO {

    private String name;
    private CardBrand cardBrand;
    private BigDecimal income;
    private BigDecimal limitBasic;

    public Cartoes toModel(){
        return new Cartoes(name, cardBrand, income, limitBasic);
    }
}
