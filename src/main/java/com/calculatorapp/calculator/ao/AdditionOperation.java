package com.calculatorapp.calculator.ao;

import com.calculatorapp.calculator.result.Result;

public class AdditionOperation implements IArithmeticOperation {

    @Override
    public void execute(Result result, float input) {
        result.setValue(result.getValue() + input);
    }
}
