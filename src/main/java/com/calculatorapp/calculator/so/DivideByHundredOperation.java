package com.calculatorapp.calculator.so;

import com.calculatorapp.calculator.result.Result;

public class DivideByHundredOperation implements IStaticArithmeticOperation {

    @Override
    public void execute(Result result) {
        result.setValue(result.getValue() / 100);
    }
}
