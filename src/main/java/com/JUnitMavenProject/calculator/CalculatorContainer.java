package com.JUnitMavenProject.calculator;

import com.JUnitMavenProject.exceptions.InvalidArithmeticOperationException;

public class CalculatorContainer {
    private Calculator positivesCalculator;
    private Calculator negativesCalculator;

    /**
     * @param positive Calculator for the positive values
     * @param negative Calculator for the negative values
     */
    //TODO: should be calc1 and calc2 and the print function should check if the result is positive
    // or negative and report  based on that
    public CalculatorContainer(Calculator positive, Calculator negative) {
        setPositivesCalculator(positive);
        setNegativesCalculator(negative);
    }

    /**
     * @return Calculator object
     */
    public Calculator getPositivesCalculator() {
        return positivesCalculator;
    }

    /**
     * @param positivesCalculator
     */
    public void setPositivesCalculator(Calculator positivesCalculator) {
        this.positivesCalculator = positivesCalculator;
    }

    /**
     * @return
     */
    public Calculator getNegativesCalculator() {
        return negativesCalculator;
    }

    /**
     * @param negativesCalculator
     */
    public void setNegativesCalculator(Calculator negativesCalculator) {
        this.negativesCalculator = negativesCalculator;
    }

    /**
     * @throws InvalidArithmeticOperationException
     */
    public void calculateAll() throws InvalidArithmeticOperationException {
        positivesCalculator.calculate();
        negativesCalculator.calculate();
    }

    /**
     * Print the result for both calculators in the container
     */
    public void print() {
        System.out.println("Positive "
                + positivesCalculator.getOperation().toString().toLowerCase()
                + " = "
                + positivesCalculator.getResult());

        System.out.println("Negative "
                + negativesCalculator.getOperation().toString().toLowerCase()
                + " = "
                + negativesCalculator.getResult());
    }
}
