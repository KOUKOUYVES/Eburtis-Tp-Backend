package com.example.tp_eburtis.Domain;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departements")
public class Departement {

    // TODO: supprimer les @JsonProperty sur les propriétés

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "designation")
    private String designation;
    @OneToMany(targetEntity = Personne.class, mappedBy = "departement", cascade = CascadeType.ALL)
    private Set<Personne> personnes = new HashSet<>();
    public Departement() {}
    public Departement(Long id, String code, String designation) {
        this.id = id;
        this.code = code;
        this.designation = designation;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Set<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(Set<Personne> personnes) {
        this.personnes = personnes;
    }
}
