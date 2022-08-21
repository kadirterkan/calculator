package com.calculatorapp.calculator.ao;

import com.calculatorapp.calculator.result.Result;
import com.calculatorapp.calculator.so.IStaticArithmeticOperation;

public class StaticArithmeticCommand implements IArithmeticOperation {

    private IStaticArithmeticOperation staticOperation;

    public StaticArithmeticCommand(IStaticArithmeticOperation staticOperation) {
        this.staticOperation = staticOperation;
    }

    @Override
    public void execute(Result result, float input) {
        staticOperation.execute(result);
    }
}
