package com.calculatorapp.calculator.result;

public class Result {

    private float value;

    public Result() {
        value = 0F;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void reset() {
        this.value = 0F;
    }
}
