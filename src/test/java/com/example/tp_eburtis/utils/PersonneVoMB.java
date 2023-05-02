package com.example.tp_eburtis.utils;

import com.example.tp_eburtis.Application.DepartementVo;
import com.example.tp_eburtis.Application.PersonneVo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class PersonneVoMB {
    private Long id;
    private String nom;
    private String prenom;
    private Integer age;
    private DepartementVo departement;

    public PersonneVoMB setId(Long id) {
        this.id = id;
        return this;
    }

    public PersonneVoMB setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public PersonneVoMB setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public PersonneVoMB setAge(Integer age) {
        this.age = age;
        return this;
    }

    public PersonneVoMB setDepartement(DepartementVo departement) {
        this.departement = departement;
        return this;
    }

    public PersonneVo build(){
        PersonneVo personneVo = mock(PersonneVo.class);
        when(personneVo.getId()).thenReturn(this.id);
        when(personneVo.getNom()).thenReturn(this.nom);
        when(personneVo.getPrenom()).thenReturn(this.prenom);
        when(personneVo.getAge()).thenReturn(this.age);
        return personneVo;
    }
}
