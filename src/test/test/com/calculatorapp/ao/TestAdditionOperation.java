package com.calculatorapp.ao;

import com.calculatorapp.calculator.ao.AdditionOperation;
import com.calculatorapp.calculator.ao.IArithmeticOperation;
import com.calculatorapp.calculator.result.Result;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestAdditionOperation {

    Result result;

    @Before
    public void init() {
        result = new Result();
    }

    @Test
    public void simpleAdditionTestSuccessful() {
        float input = 5F;
        IArithmeticOperation operation = new AdditionOperation();
        float realResult = result.getValue() + input;

        operation.execute(result, input);

        Assertions.assertEquals(realResult, result.getValue());
    }
}
