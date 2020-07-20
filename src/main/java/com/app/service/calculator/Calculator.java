package com.app.service.calculator;

public class Calculator {
    private final ICalculator calculator;

    public Calculator(ICalculator calculator) {
        this.calculator = calculator;
    }

    public void calculate() {
        calculator.calculate();
    }
}
