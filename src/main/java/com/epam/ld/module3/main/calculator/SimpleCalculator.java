package com.epam.ld.module3.main.calculator;

import java.math.BigInteger;

public class SimpleCalculator {

    private double operandA;
    private double operandB;

    public SimpleCalculator(double operandA, double operandB) {
        this.operandA = operandA;
        this.operandB = operandB;
    }

    public double plus(double operandA, double operandB) {
        return operandA + operandB;
    }

    public double plus() {
        return operandA + operandB;
    }

    public BigInteger plus(BigInteger operandA, BigInteger operandB) {
        return operandA.add(operandB);
    }

}
