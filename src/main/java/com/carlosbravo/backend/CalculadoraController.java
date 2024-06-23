package com.carlosbravo.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CalculadoraController {
    // Métodos

    @GetMapping("/suma")
    public CalculadoraModel sumar(@RequestParam(value = "op1", defaultValue = "0") float op1, @RequestParam(value = "op2", defaultValue = "0") float op2 ){
        float res = op1 + op2;
        return new CalculadoraModel(op1, op2, res);
    }

    @GetMapping("/resta")
    public CalculadoraModel restar(@RequestParam(value = "op1", defaultValue = "0") float op1, @RequestParam(value = "op2", defaultValue = "0") float op2 ){
        float res = op1 - op2;
        return new CalculadoraModel(op1, op2, res);
    }

    @GetMapping("/multiplicacion")
    public CalculadoraModel multiplicar(@RequestParam(value = "op1", defaultValue = "0") float op1, @RequestParam(value = "op2", defaultValue = "0") float op2 ){
        float res = op1 * op2;
        return new CalculadoraModel(op1, op2, res);
    }

    @GetMapping("/division")
    public CalculadoraModel dividir(@RequestParam(value = "op1", defaultValue = "0") float op1, @RequestParam(value = "op2", defaultValue = "0") float op2 ){
        float res = op1/op2;
        return new CalculadoraModel(op1, op2, res);
    }
}
