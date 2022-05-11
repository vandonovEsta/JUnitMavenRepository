package step.definitions;

import com.JUnitMavenProject.exceptions.InvalidArithmeticOperationException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.JUnitMavenProject.helpers.calculator.CalculatorHelper.sum;
import static org.junit.Assert.assertEquals;

public class CalculatorHelperSumSteps {
    private Integer actualInt;
    private Float actualFloat;

    private Double actualDouble;

    @Given("user sums two ints: {int} and {int}")
    public void user_sums_ints(Integer firstInt, Integer secondInt)
            throws InvalidArithmeticOperationException {
        actualInt = sum(firstInt, secondInt);
    }

    @Then("user should get {int} integer")
    public void user_should_get_int(Integer expectedInt) {
        assertEquals(actualInt, expectedInt);
    }

    @Given("user sums two floats: {float} and {float}")
    public void user_sums_floats(Float firstFloat, Float secondFloat)
            throws InvalidArithmeticOperationException {
        actualFloat = sum(firstFloat, secondFloat);
    }

    @Given("user sums two doubles: {double} and {double}")
    public void user_sums_doubles(Double firstDouble, Double secondDouble)
            throws InvalidArithmeticOperationException {
        actualDouble = sum(firstDouble, secondDouble);
    }


    @Then("user should get {float}")
    public void user_should_get_float(Float expectedFloat) {
        assertEquals(expectedFloat, actualFloat);
    }

    @Then("user should get {double} double")
    public void user_should_get(Double expectedDouble) {
        assertEquals(expectedDouble, actualDouble);
    }

}
