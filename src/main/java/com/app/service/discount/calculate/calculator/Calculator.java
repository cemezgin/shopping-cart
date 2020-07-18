package com.app.service.discount.calculate.calculator;

public class Calculator {
    private final ICalculator calculator;

    public Calculator(ICalculator calculator) {
        this.calculator = calculator;
    }

    public void calculate() {
        calculator.calculate();
    }
}
