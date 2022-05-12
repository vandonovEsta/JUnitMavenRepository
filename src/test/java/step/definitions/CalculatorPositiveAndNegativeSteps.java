package step.definitions;

import com.JUnitMavenProject.calculator.Calculator;
import com.JUnitMavenProject.enums.Operations;
import com.JUnitMavenProject.exceptions.InvalidArithmeticOperationException;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPositiveAndNegativeSteps {
    List<Double> firstColumn = new ArrayList<>();
    List<Double> secondColumn = new ArrayList<>();
    Calculator calculator;


    private void manageDataTable(io.cucumber.datatable.DataTable dataTable) {
        for (List<String> row :
                dataTable.cells()) {
            firstColumn.add(Double.valueOf(row.get(0)));
            secondColumn.add(Double.valueOf(row.get(1)));
        }
    }

    @ParameterType(".*")
    public Operations operation(String operationString) {
        return Operations.valueOf(operationString.toUpperCase());
    }

    @Given("I have the following sets of numbers:")
    public void user_has_the_following_sets_of_numbers(io.cucumber.datatable.DataTable dataTable) {
        manageDataTable(dataTable);
    }

    //User sums           the numbers in each column
    @When("I do {operation} of the numbers in each column")
    public void user_sums_th_numbers_in_each_column(Operations operation)
            throws InvalidArithmeticOperationException {
        calculator = new Calculator(Double.valueOf(0), Double.valueOf(0), operation);
        calculator.calculateMultiple(firstColumn);
        calculator.calculateMultiple(secondColumn);

    }

    @Then("The result of each column should be printed out")
    public void the_result_of_each_column_should_be_printed_out() {
        calculator.printResults();
    }


}
