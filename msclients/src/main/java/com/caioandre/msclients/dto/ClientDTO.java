package com.caioandre.msclients.dto;

import com.caioandre.msclients.model.Client;
import lombok.Data;

@Data
public class ClientDTO {
    private String cpf;
    private String name;
    private Integer age;

    public Client toModel(){
        return new Client(cpf, name, age);
    }
}
