package com.carlosbravo.backend;

public class CalculadoraModel {
    // Variables

    private final float op1;
    private final float op2;
    private final float res;

    // Constructor

    public CalculadoraModel( float op1, float op2, float res){
        this.op1 = op1;
        this.op2 = op2;
        this.res = res;
    }

    // Métodos

    public float getOp1() {
        return op1;
    }

    public float getOp2() {
        return op2;
    }

    public float getRes() {
        return res;
    }
}
