package com.example.tp_eburtis.utils;
import com.example.tp_eburtis.Domain.Departement;
import com.example.tp_eburtis.Domain.Personne;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class PersonneMB {

    private Long id;
    private String nom;
    private String prenom;
    private int age;
    private Departement departement;

    public PersonneMB setId(Long id) {
        this.id = id;
        return this;
    }

    public PersonneMB setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public PersonneMB setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public PersonneMB setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonneMB setDepartement(Departement departement) {
        this.departement = departement;
        return this;
    }

    public Personne build(){
        Personne personne = mock(Personne.class);
        when(personne.getId()).thenReturn(this.id);
        when(personne.getNom()).thenReturn(this.nom);
        when(personne.getPrenom()).thenReturn(this.prenom);
        when(personne.getAge()).thenReturn(this.age);
        when(personne.getDepartement()).thenReturn(this.departement);
        return personne;
    }
}
