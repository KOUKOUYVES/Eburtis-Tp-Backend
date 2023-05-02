package com.example.tp_eburtis.Servive;


import com.example.tp_eburtis.Application.PersonneVo;
import com.example.tp_eburtis.Domain.Departement;
import com.example.tp_eburtis.Domain.Personne;
import com.example.tp_eburtis.Domain.PersonneRepository;
import com.example.tp_eburtis.Infrastructure.PersonneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class testPersonneService {

    @Mock
    private PersonneRepository personneRepository;
    @InjectMocks
    private PersonneService personneService;
    @Test
    @DisplayName("test unitaire de la méthode findAll() de PersonneService")
    public  void  testAllPersonne(){


        // création d'une liste de personnes pour simuler les données de la base de données
        List<Personne> personnes = new ArrayList<>();
        Personne personne1 = new Personne(1L, "Yedagne", "Anicet", 22, new Departement(1L,"DAB","Dabou"));
        Personne personne2 = new Personne(2L, "Akpa", "Bedi", 23, new Departement(2L,"YAM","Yamoussoukro"));
        personnes.add(personne1);
        personnes.add(personne2);

        // simuler le comportement de la méthode findAll() dans le repository
        when(personneRepository.findAll()).thenReturn(personnes);

        // appeler la méthode findAll() dans le service et vérifier la liste de personnes retournée
        List<PersonneVo> personnesVo = personneService.findAll();
        Assertions.assertNotNull(personnesVo);
        assertEquals(personnes.size(), personnesVo.size());

        // vérifier les détails des personnes dans la liste retournée

        PersonneVo personneVo1 = personnesVo.get(0);
        assertEquals(personne1.getId(), personneVo1.getId());
        assertEquals(personne1.getNom(), personneVo1.getNom());
        assertEquals(personne1.getPrenom(), personneVo1.getPrenom());
        assertEquals(personne1.getDepartement().getId(), personneVo1.getDepartement().getId());
        assertEquals(personne1.getDepartement().getCode(), personneVo1.getDepartement().getCode());
        assertEquals(personne1.getDepartement().getDesignation(), personneVo1.getDepartement().getDesignation());

        PersonneVo personneVo2 = personnesVo.get(1);
        assertEquals(personne2.getId(), personneVo2.getId());
        assertEquals(personne2.getNom(), personneVo2.getNom());
        assertEquals(personne2.getPrenom(), personneVo2.getPrenom());
        assertEquals(personne2.getDepartement().getId(), personneVo2.getDepartement().getId());
        assertEquals(personne2.getDepartement().getCode(), personneVo2.getDepartement().getCode());
        assertEquals(personne2.getDepartement().getDesignation(), personneVo2.getDepartement().getDesignation());
    }

    @Test
    @DisplayName("Test unitaire de la methode findById de service personne")
    public void testFindById(){
        //initialisation de donnee
        Long id = 1l;
        Departement departement = new Departement(1l,"DAB","Dabou");
        Personne personne = new Personne(id,"yves","Armand",65,departement);

        //stimulation de la methode
        when(personneRepository.findById(id)).thenReturn(Optional.of(personne));

        //appel de ma methode
        Optional<PersonneVo> personneVo = personneService.findById(id);
        Assertions.assertNotNull(personneVo);

        //verification de la reponse
        assertEquals(true, personneVo.isPresent());
        assertEquals("yves", personneVo.get().getNom());
        assertEquals("Armand", personneVo.get().getPrenom());
        assertEquals(65, personneVo.get().getAge());
        assertEquals(1L, personneVo.get().getDepartement().getId());
    }

}

