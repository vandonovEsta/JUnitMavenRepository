package com.JUnitMavenProject.calculator;

import com.JUnitMavenProject.enums.Operations;
import com.JUnitMavenProject.exceptions.InvalidArithmeticOperationException;

import static com.JUnitMavenProject.enums.utils.EnumUtils.returnOperationsFromString;

/**
 * Accepts two numbers and an arithmetic operation to execute against them.
 */
public class Calculator {
    private final double firstNumber;
    private final double secondNumber;
    private final Operations operation;

    private double result;

    /**
     * Base constructor
     *
     * @param firstNumber
     * @param secondNumber
     * @param operation
     */
    public Calculator(double firstNumber, double secondNumber, Operations operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    /**
     * Accepts String instead of enum for the operation and calls the base constructor
     *
     * @param firstNumber
     * @param secondNumber
     * @param operation
     */
    public Calculator(double firstNumber, double secondNumber, String operation) {
        this(firstNumber, secondNumber, returnOperationsFromString(operation));
    }


    /**
     * @return double digit after the calculation is complete. Input is set from the constructor
     * @throws InvalidArithmeticOperationException - returns a custom exception if the operation was invalid
     */
    public double calculate() throws InvalidArithmeticOperationException {
        switch (operation) {
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
