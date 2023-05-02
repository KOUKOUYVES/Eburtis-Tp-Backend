package com.example.tp_eburtis.Application;

import com.example.tp_eburtis.Domain.Personne;

public class PersonneVo {
    private Long id;
    private String nom;
    private String prenom;
    private Integer age;
    private DepartementVo departement;
    public PersonneVo() {}
    public PersonneVo(Personne personne, DepartementVo departementVo) {
        this.id = personne.getId();
        this.nom = personne.getNom();
        this.prenom = personne.getPrenom();
        this.age = personne.getAge();
        this.departement = departementVo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public DepartementVo getDepartement() {
        return departement;
    }

    public void setDepartement(DepartementVo departement) {
        this.departement = departement;
    }
}
