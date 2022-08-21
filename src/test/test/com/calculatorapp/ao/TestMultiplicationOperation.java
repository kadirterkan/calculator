package com.calculatorapp.ao;

import com.calculatorapp.calculator.ao.IArithmeticOperation;
import com.calculatorapp.calculator.ao.MultiplicationOperation;
import com.calculatorapp.calculator.result.Result;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestMultiplicationOperation {

    Result result;

    @Before
    public void init() {
        result = new Result();
    }

    @Test
    public void simpleMultiplicationTestSuccessful() {
        result.setValue(5F);
        float input = 5F;
        float realResult = result.getValue() * input;

        IArithmeticOperation operation = new MultiplicationOperation();

        operation.execute(result, input);

        Assertions.assertEquals(realResult, result.getValue());
    }
}
