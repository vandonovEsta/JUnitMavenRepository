package com.JUnitMavenProject.calculator;

import com.JUnitMavenProject.enums.Operations;
import com.JUnitMavenProject.exceptions.InvalidArithmeticOperationException;

public class Calculator {
    private double firstNumber;
    private double secondNumber;
    private Operations operation;

    private double result;

    public Calculator(double firstNumber, double secondNumber, Operations operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    public Calculator(double firstNumber, double secondNumber, String operation) {
        this(firstNumber, secondNumber, setOperationFromString(operation));
    }

    private static Operations setOperationFromString(String operationString){
        return Operations.valueOf(operationString.toUpperCase());
    }
    public double calculate() throws InvalidArithmeticOperationException {
        switch (operation){
            case SUM:
                result = firstNumber + secondNumber;
            break;
            case DIVISION:
                result = firstNumber / secondNumber;
            break;
            case SUBTRACTION:
                result = firstNumber - secondNumber;
                break;
            case MULTIPLICATION:
                result = firstNumber * secondNumber;
                break;
            default:
                throw new InvalidArithmeticOperationException("The operation was not valid");
        }

        return result;
    }

}
