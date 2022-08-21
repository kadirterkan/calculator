package com.calculatorapp.calculator.ao;

import com.calculatorapp.calculator.result.Result;

public class DivisionOperation implements IArithmeticOperation {

    @Override
    public void execute(Result result, float input) {
        result.setValue(result.getValue() / input);
    }
}
