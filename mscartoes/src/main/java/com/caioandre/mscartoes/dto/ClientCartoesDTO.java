package com.caioandre.mscartoes.dto;


import com.caioandre.mscartoes.model.ClientCartoes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientCartoesDTO {

    private String name;
    private String cardBrand;
    private BigDecimal limitReleased;


    public static ClientCartoesDTO fromModel(ClientCartoes model){
        return new ClientCartoesDTO(
                model.getCartoes().getName(),
                model.getCartoes().getCardBrand().toString(),
                model.getLimitBasic()
        );
    }
}
