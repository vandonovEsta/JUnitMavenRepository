package step.definitions;

import com.JUnitMavenProject.controllers.CalculatorController;
import com.JUnitMavenProject.exceptions.InvalidArithmeticOperationException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorHelperCalculateSteps {
    private CalculatorController containers;

    @Given("user has the following data")
    public void user_has_the_following_data(io.cucumber.datatable.DataTable dataTable) throws InvalidArithmeticOperationException {
        containers = new CalculatorController(dataTable.cells().subList(1, dataTable.cells().size()));

    }

    @When("user calculates")
    public void user_calculates() throws InvalidArithmeticOperationException {
        containers.calculateAll();
    }

    @Then("user Print result(s)")
    public void user_prints_output() {
        containers.print();

    }
}
