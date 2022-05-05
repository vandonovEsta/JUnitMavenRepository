package com.JUnitMavenProject.calculator;

import com.JUnitMavenProject.enums.Operations;
import com.JUnitMavenProject.exceptions.InvalidArithmeticOperationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {
    private double firstNumber = 55.7;
    private double secondNumber = 73.98;


    @Test
    public void sumTest() throws InvalidArithmeticOperationException {
        Calculator calculator = new Calculator(firstNumber, secondNumber, Operations.SUM);
        double result = calculator.calculate();

        assertEquals(firstNumber + secondNumber, result, "Wrong sum calculation");
    }

    @Test
    public void divideTest() throws InvalidArithmeticOperationException {
        Calculator calculator = new Calculator(firstNumber, secondNumber, Operations.DIVISION);
        double result = calculator.calculate();

        assertEquals(firstNumber / secondNumber, result, "Wrong division calculation");
    }

    @Test
    public void subtractionTest() throws InvalidArithmeticOperationException {
        Calculator calculator = new Calculator(firstNumber, secondNumber, Operations.SUBTRACTION);
        double result = calculator.calculate();

        assertEquals(firstNumber - secondNumber, result, "Wrong division calculation");
    }

    @Test
    public void multiplicationTest() throws InvalidArithmeticOperationException {
        Calculator calculator = new Calculator(firstNumber, secondNumber, Operations.MULTIPLICATION);
        double result = calculator.calculate();

        assertEquals(firstNumber * secondNumber, result, "Wrong division calculation");
    }

    @ParameterizedTest
    @EnumSource(Operations.class)
    public void enumCalculationOperationTest(Operations operation) throws InvalidArithmeticOperationException {
        Calculator calculator = new Calculator(firstNumber, secondNumber, operation);
        double result = calculator.calculate();
        double expectedResult = 0;

        switch (operation) {
            case SUM:
                expectedResult = firstNumber + secondNumber;
                break;
            case DIVISION:
                expectedResult = firstNumber / secondNumber;
                break;
            case SUBTRACTION:
                expectedResult = firstNumber - secondNumber;
                break;
            case MULTIPLICATION:
                expectedResult = firstNumber * secondNumber;
                break;
        }

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "4,4,8", "10,0,10"})
    public void csvSourceSumTest(String firstNumberString, String secondNumberString, String expectedResultString)
            throws InvalidArithmeticOperationException {
        double firstNumber = Double.valueOf(firstNumberString);
        double secondNumber = Double.valueOf(secondNumberString);
        double expectedResult = Double.valueOf(expectedResultString);
        double result;

        Calculator calculator = new Calculator(firstNumber, secondNumber, Operations.SUM);
        result = calculator.calculate();

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/testData/input.csv", numLinesToSkip = 0)
    public void csvFileSumTest(String firstNumberString, String secondNumberString, String expectedResultString)
            throws InvalidArithmeticOperationException {
        double firstNumber = Double.valueOf(firstNumberString);
        double secondNumber = Double.valueOf(secondNumberString);
        double expectedResult = Double.valueOf(expectedResultString);
        double result;

        Calculator calculator = new Calculator(firstNumber, secondNumber, Operations.SUM);
        result = calculator.calculate();

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {22.0, 23.04, 45})
    public void passNumbersToSumTest(double numberToAdd)
            throws InvalidArithmeticOperationException {
        double result;

        Calculator calculator = new Calculator(firstNumber, numberToAdd, Operations.SUM);
        result = calculator.calculate();

        assertEquals(firstNumber + numberToAdd, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"SUM", "sum"})
    public void testOverloadedConstructorTest(String operation) throws InvalidArithmeticOperationException {
        Calculator calculator = new Calculator(firstNumber, secondNumber, operation);
        double result = calculator.calculate();

        assertEquals(firstNumber + secondNumber , result);
    }
}
