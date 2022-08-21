package com.calculatorapp.controller;

import com.calculatorapp.calculator.ao.IArithmeticOperation;
import com.calculatorapp.calculator.result.Result;

public class Calculator {

    private Result result;
    private float input;

    public Calculator() {
        this.result = new Result();
    }

    public void calculate(IArithmeticOperation operation) {
        operation.execute(result, input);
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public float getInput() {
        return input;
    }

    public void setInput(float input) {
        this.input = input;
    }

    public float getValue() {
        return this.result.getValue();
    }

    public void setValue(float value) {
        this.result.setValue(value);
    }

    public void allClear() {
        result.reset();
        input = 0F;
    }

    public void clear() {

    }
}
