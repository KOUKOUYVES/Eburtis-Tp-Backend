package com.example.tp_eburtis.Infrastructure;

import com.example.tp_eburtis.Application.DepartementVo;
import com.example.tp_eburtis.Application.PersonneVo;
import com.example.tp_eburtis.Domain.Departement;
import com.example.tp_eburtis.Domain.DepartementRepository;
import com.example.tp_eburtis.Domain.Personne;
import com.example.tp_eburtis.Domain.PersonneRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private DepartementRepository departementRepository;

    //methode permettant d'afficher tous les departement y compris les personne qui appartiennent a ce departement
    public List<PersonneVo> findAll() {
        List<Personne> personnes = personneRepository.findAll();
        return personnes.stream().map(dep -> new PersonneVo(dep, new DepartementVo(dep.getDepartement()))).collect(Collectors.toList());
    }


    //methode permettant d'afficher un departement y compris les personne concerné
    public PersonneVo getPersonneByIdAndDepartementId(Long id) {
        Personne personne = personneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("La personne avec " + id + " est introuvable"));
        Departement departement = departementRepository.findById(personne.getDepartement().getId())
                .orElseThrow(() -> new EntityNotFoundException("Département with id " + personne.getDepartement().getId() + " not found"));
        return new PersonneVo(personne, new DepartementVo(departement));
    }


    public Optional<PersonneVo> findById(Long id) {
        Optional<Personne> personneOptional = personneRepository.findById(id);
        return personneOptional.map(p -> new PersonneVo(p, new DepartementVo(p.getDepartement())));
    }

    //methode permettant de supprimer une personne
    public void deleteById(Long id) {
        personneRepository.deleteById(id);
    }

    public PersonneVo update(Long id, PersonneVo personneVo) {
        Optional<Personne> personneOptional = personneRepository.findById(id);
        if (personneOptional.isPresent()) {
            Personne personne = personneOptional.get();
            Departement departement = departementRepository.findById(personneVo.getDepartement().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Département introuvable"));
            personne.setNom(personneVo.getNom());
            personne.setPrenom(personneVo.getPrenom());
            personne.setAge(personneVo.getAge());
            personne.setDepartement(departement);
            Personne updatedPersonne = personneRepository.save(personne);
            return new PersonneVo(updatedPersonne, new DepartementVo(updatedPersonne.getDepartement()));
        }
        return null;
    }

    public PersonneVo createNewPeronne(PersonneVo personneVo) {
        if (personneVo.getDepartement() == null || personneVo.getDepartement().getId() == null) {
            throw new IllegalArgumentException("Identifiant du département manquant");
        }
        Departement departement = departementRepository.findById(personneVo.getDepartement().getId())
                .orElseThrow(() -> new IllegalArgumentException("Département introuvable"));
        if (departement == null) {
            throw new IllegalArgumentException("Département invalide");
        }
       // Personne personne = new Personne(null, personneVo.getNom(), personneVo.getPrenom(), personneVo.getAge());
        Personne personne = new Personne(null, personneVo.getNom(), personneVo.getPrenom(), personneVo.getAge(),departement);
        Personne savedPersonne = personneRepository.save(personne);
        return new PersonneVo(savedPersonne, new DepartementVo(savedPersonne.getDepartement()));
    }


}
