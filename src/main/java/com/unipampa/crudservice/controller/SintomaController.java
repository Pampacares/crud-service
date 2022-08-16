package com.unipampa.crudservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unipampa.crudservice.interfaces.ISintomaService;
import com.unipampa.crudservice.model.Sintoma;


@RestController
@RequestMapping(value = "/sintoma")
public class SintomaController {

    @Autowired
    private ISintomaService sintomaService;
    
    @GetMapping(value = "/listar")
    public ResponseEntity<String> listarSintomas() {
        List<Sintoma> sintomas = sintomaService.listarSintomas();

        try {
            String json = new ObjectMapper().writeValueAsString(sintomas);

            return new ResponseEntity<String>(json.toString(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    }
