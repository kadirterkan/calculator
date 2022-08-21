package com.calculatorapp.controller;

import com.calculatorapp.calculator.ao.*;
import com.calculatorapp.calculator.so.ChangeSignOperation;
import com.calculatorapp.calculator.so.DivideByHundredOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class CalculatorController {

    private final Calculator calculator = new Calculator();
    @FXML
    private Button resultButton;
    @FXML
    private Button clearButton;
    @FXML
    private Label resultLabel;
    private IArithmeticOperation operation = null;
    private boolean operationClicked = true;
    private boolean allClear = true;
    private String number = "0";

    @FXML
    private void numberAction(final ActionEvent e) {
        Button input = (Button) e.getTarget();
        numberInput(input.getText());
        setInput();
    }

    private void numberInput(String input) {
        if (operationClicked) {
            number = input;
            operationClicked = false;
            allClear = false;
            clearButton.setText("C");
        } else {
            number += input;
        }
        setInput();
    }

    @FXML
    private void clearAction(final ActionEvent e) {
        if (allClear) {
            calculator.allClear();
        } else {
            number = "0";
            clearButton.setText("AC");
            allClear = true;
        }
        setInput();
    }

    @FXML
    private void operationAction(final ActionEvent e) {
        Button operationButton = (Button) e.getTarget();
        String operationCase = operationButton.getText();

        operationInput(operationCase);
    }

    public void operationInput(String stringOperation) {
        switch (stringOperation) {
            case "+":
                operation = new AdditionOperation();
                break;
            case "-":
                operation = new SubtractionOperation();
                break;
            case "x":
                operation = new MultiplicationOperation();
                break;
            case "/":
                operation = new DivisionOperation();
                break;
        }

        setValue();
        operationClicked = true;
    }

    @FXML
    private void calculateAction(final ActionEvent e) {
        if (operation != null) {
            float input = Float.parseFloat(number);

            calculator.setInput(input);
            calculator.calculate(operation);
            setResult();
        }
        operationClicked = true;
    }

    @FXML
    private void staticOperations(final ActionEvent e) {
        Button targetButton = (Button) e.getTarget();
        String operationCase = targetButton.getText();

        switch (operationCase) {
            case "+/-":
                operation = new StaticArithmeticCommand(new ChangeSignOperation());
                break;
            case "%":
                operation = new StaticArithmeticCommand(new DivideByHundredOperation());
                break;
        }
        setValue();
        resultButton.fire();
    }

    private void setValue() {
        if (!allClear) {
            calculator.setValue(Float.parseFloat(resultLabel.getText()));
        }
    }

    private void setResult() {
        float res = calculator.getValue();
        String result;
        if (res == (long) res) {
            result = String.valueOf((long) calculator.getValue());
        } else {
            result = String.valueOf(calculator.getValue());
        }
        resultLabel.setText(result);
    }

    private void setInput() {
        resultLabel.setText(number);
    }

    public void keyEvent(final KeyEvent event) {
        String input = event.getText();
        try {
            Integer.parseInt(input);
            numberInput(input);
        } catch (NumberFormatException e) {
            int code = event.getCode().getCode();

            switch (code) {
                case 47:
                    numberInput(input);
                    break;
                case 52:
                case 61:
                case 45:
                case 55:
                    operationInput(input);
                    break;
                case 16:
                    break;
                case 10:
                    resultButton.fire();
                    break;
            }
        }
    }
}
