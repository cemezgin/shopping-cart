package com.app.service.calculator;

public class Calculator {
    private final CalculatorInterface calculator;

    public Calculator(CalculatorInterface calculator) {
        this.calculator = calculator;
    }

    public void calculate() {
        calculator.calculate();
    }
}
