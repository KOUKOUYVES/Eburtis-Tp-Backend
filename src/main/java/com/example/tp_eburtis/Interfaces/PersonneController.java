package com.example.tp_eburtis.Interfaces;
import com.example.tp_eburtis.Application.PersonneVo;
import com.example.tp_eburtis.Domain.Personne;
import com.example.tp_eburtis.Infrastructure.PersonneService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
@CrossOrigin("*")
public class PersonneController {
    @Autowired
    private PersonneService personneService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void configureObjectMapper()
    {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    // Methode permettant d'afficher toutes les personnes avec leur departement
    @GetMapping("/getAllPersonnes")
    public ResponseEntity<List<PersonneVo>>getAllPersonnes() {
        List<PersonneVo> personnes = personneService.findAll();
        return new ResponseEntity<>(personnes, HttpStatus.OK);
    }

    @GetMapping("/getPersonneById/{id}")
    public ResponseEntity<PersonneVo> findById(@PathVariable Long id) {
        Optional<PersonneVo> personneOptional = personneService.findById(id);
        return personneOptional.map(personneVo -> new ResponseEntity<>(personneVo, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/updatePersonneById/{id}")
    public ResponseEntity<PersonneVo> update(@PathVariable Long id, @RequestBody PersonneVo personneVo) {
        PersonneVo updatedPersonne = personneService.update(id, personneVo);
        if (updatedPersonne != null) {
            return new ResponseEntity<>(updatedPersonne, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //methode permettant de supprimer une personne
    @DeleteMapping("/personneDelete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        personneService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //ajouter une personnes dans la DB
    @PostMapping("/addPersonne")
    public ResponseEntity<PersonneVo> createPersonne(@RequestBody PersonneVo personneVo) {
        PersonneVo createdPersonne = personneService.createNewPeronne(personneVo);
        return new ResponseEntity<>(createdPersonne, HttpStatus.CREATED);
    }

}
