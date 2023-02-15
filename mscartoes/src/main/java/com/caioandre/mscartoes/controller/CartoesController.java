package com.caioandre.mscartoes.controller;

import com.caioandre.mscartoes.dto.CartoesDTO;
import com.caioandre.mscartoes.dto.ClientCartoesDTO;
import com.caioandre.mscartoes.model.Cartoes;
import com.caioandre.mscartoes.model.ClientCartoes;
import com.caioandre.mscartoes.services.CartoesService;
import com.caioandre.mscartoes.services.ClientCartoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartoesController {

    private final CartoesService service;
    private final ClientCartoesService clientCartoesService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CartoesDTO cartoesDTO){
        Cartoes cartoes = cartoesDTO.toModel();
        service.save(cartoes);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Cartoes>> getCartoesIncome(@RequestParam("income") Long income){
        List<Cartoes> list = service.getCartoesIncomeLessThanEqual(income);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClientCartoesDTO>> getCartoesByClientCpf(@RequestParam("cpf") String cpf){
        List<ClientCartoes> clientCartoes = clientCartoesService.listCartoesByCpf(cpf);
        List<ClientCartoesDTO> listDTO = clientCartoes.stream()
                .map(ClientCartoesDTO::fromModel).toList();

        return ResponseEntity.ok(listDTO);
    }
}
