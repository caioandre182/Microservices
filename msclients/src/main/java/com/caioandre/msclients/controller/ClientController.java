package com.caioandre.msclients.controller;

import com.caioandre.msclients.dto.ClientDTO;
import com.caioandre.msclients.model.Client;
import com.caioandre.msclients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClientDTO clientDTO){
        Client client = clientDTO.toModel();
        service.save(client);
        URI headersLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();

        return ResponseEntity.created(headersLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity getByCpf(@RequestParam("cpf") String cpf){
        Optional<Client> client = service.getByCpf(cpf);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }
}
