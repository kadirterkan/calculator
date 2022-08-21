package com.calculatorapp.calculator.so;

import com.calculatorapp.calculator.result.Result;

public class ChangeSignOperation implements IStaticArithmeticOperation {

    @Override
    public void execute(Result result) {
        result.setValue(-result.getValue());
    }
}
