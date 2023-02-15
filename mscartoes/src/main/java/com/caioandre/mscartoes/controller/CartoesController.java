package com.caioandre.mscartoes.controller;

import com.caioandre.mscartoes.dto.CartoesDTO;
import com.caioandre.mscartoes.model.Cartoes;
import com.caioandre.mscartoes.services.CartoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartoesController {

    private final CartoesService service;

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

}
