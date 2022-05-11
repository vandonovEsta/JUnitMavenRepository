package com.JUnitMavenProject.controllers;

import com.JUnitMavenProject.calculator.Calculator;
import com.JUnitMavenProject.calculator.CalculatorContainer;
import com.JUnitMavenProject.exceptions.InvalidArithmeticOperationException;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {

    private List<CalculatorContainer> calculatorContainers = new ArrayList<>();

    /**
     * Handles a pair of values from the list and creates a container for each pair.
     * The first value of each nested list is used for the first calculator.
     * The second value of each nested list is used for the second calculator.
     * There is an operation in the third value of the second nested list.
     *
     * @param entries
     */
    public CalculatorController(List<List<String>> entries) {
        for (int i = 0; i < entries.size(); i += 2) {
            calculatorContainers.add(
                    new CalculatorContainer(new Calculator(
                            Double.valueOf(entries.get(i).get(0)),
                            Double.valueOf(entries.get(i + 1).get(0)),
                            entries.get(i + 1).get(2)),
                            new Calculator(
                                    Double.valueOf(entries.get(i).get(1)),
                                    Double.valueOf(entries.get(i + 1).get(1)),
                                    entries.get(i + 1).get(2)))
            );

        }
    }

    /**
     * calculateAll() method for each container in calculatorContainers
     *
     * @throws InvalidArithmeticOperationException
     */
    public void calculateAll() throws InvalidArithmeticOperationException {
        for (CalculatorContainer container :
                calculatorContainers) {
            container.calculateAll();
        }
    }

    /**
     * calls the print() method for each container in calculatorContainers
     */
    public void print() {

        for (CalculatorContainer container :
                calculatorContainers) {
            container.print();
        }


    }
}
