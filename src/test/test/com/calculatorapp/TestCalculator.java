package com.calculatorapp;

import com.calculatorapp.calculator.ao.AdditionOperation;
import com.calculatorapp.controller.Calculator;
import com.calculatorapp.calculator.ao.SubtractionOperation;
import com.calculatorapp.calculator.result.Result;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestCalculator {

    Result result;
    Calculator calculator;

    @Before
    public void init() {
        result = new Result();
        calculator = new Calculator();
    }

    @Test
    public void testAdditionOperationTestSuccessful() {
        calculator.setInput(5F);

        calculator.calculate(new AdditionOperation());

        Assertions.assertEquals(5F, calculator.getResult().getValue());
    }

    @Test
    public void testSubtractionOperationTestSuccessful() {
        calculator.setInput(5F);

        calculator.calculate(new SubtractionOperation());

        Assertions.assertEquals(-5F, calculator.getResult().getValue());
    }
}
