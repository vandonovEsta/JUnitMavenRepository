package com.JUnitMavenProject.helpers.calculator;

import com.JUnitMavenProject.enums.Operations;
import com.JUnitMavenProject.exceptions.InvalidArithmeticOperationException;

import static com.JUnitMavenProject.enums.Operations.SUM;

/**
 * Extend Calculator.
 * Provides static methods calculation
 */
public class CalculatorHelper extends com.JUnitMavenProject.calculator.Calculator {
    public CalculatorHelper(Double firstNumber, Double secondNumber, String Operations) {
        super(firstNumber, secondNumber, Operations);
    }

    /**
     * Static method for custom calculations
     *
     * @param firstNumber
     * @param secondNumber
     * @param operation
     * @return
     * @throws InvalidArithmeticOperationException
     */
    public static double customCalculation(double firstNumber, double secondNumber, Operations operation)
            throws InvalidArithmeticOperationException {
        return calculationFunction(firstNumber, secondNumber, operation);
    }

    /**
     * @param firstNumber
     * @param secondNumber
     * @return
     * @throws InvalidArithmeticOperationException
     */
    public static double sum(double firstNumber, double secondNumber)
            throws InvalidArithmeticOperationException {
        return customCalculation(firstNumber, secondNumber, SUM);
    }

    /**
     * @param firstInt
     * @param secondInt
     * @return
     * @throws InvalidArithmeticOperationException
     */
    public static int sum(int firstInt, int secondInt)
            throws InvalidArithmeticOperationException {
        return (int) sum((double) firstInt, (double) secondInt);
    }

    /**
     * @param firstFloat
     * @param secondFloat
     * @return
     * @throws InvalidArithmeticOperationException
     */
    public static float sum(float firstFloat, float secondFloat)
            throws InvalidArithmeticOperationException {
        return (float) sum((double) firstFloat, (double) secondFloat);
    }
}
