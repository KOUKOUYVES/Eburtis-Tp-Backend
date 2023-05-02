package com.example.tp_eburtis;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.class)
@AutoConfigureMockMvc
@Tag("CalculTestUnitaire")
@DisplayName("test unitaire pour la classe calcul")
public class CalculTestUnitaire {
    private Calcul calcul;
    @BeforeEach

    public void appel() {
        calcul = new Calcul(8, 6);
    }

    /////Test pour verifier la methode additionner
    @Test
    @DisplayName("Test pour l'addition")
    public void additionnerTest() {
        float result = calcul.additionner(calcul.a, calcul.b);
        Assertions.assertEquals(14, result);
    }

    /////Test pour verifier la methode soustraction(soustraire)
    @Test
    @DisplayName("Test de la soustraction")
    public void soustraireTest() {
        float result = calcul.soustraire(calcul.a, calcul.b);
        Assertions.assertEquals(2, result);
    }

    /////Test pour verifier la methode multiplication
    @Test
    @DisplayName("Test de la multiplication")
    public void multiplierTest() {
        float result = calcul.multiplier(calcul.a, calcul.b);
        Assertions.assertEquals(48, result);
    }

    /////Test pour verifier la methode division
    @Test
    @DisplayName("Test de la division")
    public void diviserTest() throws Exception {
        float result = calcul.diviser(calcul.a, calcul.b);
        Assertions.assertEquals(1.3333333f, result, 0.00001f);
    }

    /////Test pour verifier la methode division par zero
    @Test
    @DisplayName("Test de la division par zéro")
    public void diviserTesrParZero() {
        Assertions.assertThrows(Exception.class, () -> calcul.diviser(calcul.a, 0));
    }

    /////Test pour verifier la methode multiplication
    @Test
    @DisplayName("Test du carré")
    public void carreTest() {
        float result = calcul.carre(calcul.a);
        Assertions.assertEquals(64, result);
    }

    /////Test pour verifier la methode multiplication
    @Test
    @DisplayName("Test de l'identité remarquable")
    public void testIdentiteRemarquable() {
        float result = calcul.identiteRemarquable(calcul.a, calcul.b);
        Assertions.assertEquals(196, result);
    }
}
