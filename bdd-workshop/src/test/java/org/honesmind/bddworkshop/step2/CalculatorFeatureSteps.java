package org.honesmind.bddworkshop.step2;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorFeatureSteps {

    private CalculatorService calculatorService;
    private int currentResult;

    @Given("I have a calculator")
    public void initializeCalculator() {
        calculatorService = new CalculatorService();
    }

    @When("the user wants to execute the {int} + {int} operation")
    public void the_user_execute_add_operation(final int x, final int y) {
        currentResult = calculatorService.execute(x, y, '+');
    }

    @Then("the user gets {int}")
    public void the_user_gets_the_result(final int expectedResult) {
        assertThat(currentResult)
            .withFailMessage("Expecting " + expectedResult + " but is " + currentResult)
            .isEqualTo(expectedResult);
    }
}