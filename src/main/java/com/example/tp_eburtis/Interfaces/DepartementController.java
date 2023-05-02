package com.example.tp_eburtis.Interfaces;


import com.example.tp_eburtis.Application.DepartementVo;
import com.example.tp_eburtis.Infrastructure.DepartementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DepartementController {
    @Autowired
    private DepartementService departementService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    //c'est classe  fourni par Jackson (une bibliothèque de sérialisation/désérialisation JSON pour Java) pour convertir des objets Java en JSON et vice versa.
    public void configureObjectMapper() {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @GetMapping("/getAllDepartements")
    public ResponseEntity<List<DepartementVo>> findAll(){
        List<DepartementVo> departement = departementService.getAllDepartement();
        return new ResponseEntity<>(departement, HttpStatus.OK);
    }

}
