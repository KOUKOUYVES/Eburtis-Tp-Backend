package com.example.tp_eburtis.Infrastructure;

import com.example.tp_eburtis.Application.DepartementVo;
import com.example.tp_eburtis.Domain.Departement;
import com.example.tp_eburtis.Domain.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DepartementService {
    @Autowired
    private DepartementRepository departementRepository;

    public List<DepartementVo> getAllDepartement(){
        List<Departement> departements = departementRepository.findAll();
        //La méthode stream() est appelée sur la collection departements pour créer un flux d'éléments
        return departements.stream()
                //La méthode map() est ensuite utilisée pour appliquer une fonction de mapping à chaque élément du flux
                .map(departement -> {
                    DepartementVo departementVo = new DepartementVo();
                    departementVo.setId(departement.getId());
                    departementVo.setCode(departement.getCode());
                    departementVo.setDesignation(departement.getDesignation());
                    return departementVo;
                })
                //La méthode collect() est utilisée pour collecter les éléments mappés dans une Liste<DepartementVo>
                .collect(Collectors.toList());
    }
}
