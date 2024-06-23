package com.carlosbravo.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraControllerTest {

    CalculadoraController calculadoraController;

    @BeforeEach
    void setUp() {
        calculadoraController = new CalculadoraController();
    }

    @Test
    void sumar() {
        CalculadoraModel obj = calculadoraController.sumar(10,5);
        Assertions.assertEquals(obj.getRes(), 10 + 5);
    }

    @Test
    void restar() {
        CalculadoraModel obj = calculadoraController.restar(10,5);
        Assertions.assertEquals(obj.getRes(), 10 - 5);
    }

    @Test
    void multiplicar() {
        CalculadoraModel obj = calculadoraController.multiplicar(10,5);
        Assertions.assertEquals(obj.getRes(), 10 * 5);
    }

    @Test
    void dividir() {
        CalculadoraModel obj = calculadoraController.dividir(10,5);
        Assertions.assertEquals(obj.getRes(), 10/5);
    }
}