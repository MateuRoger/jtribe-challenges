package org.honesmind.bddworkshop.step5;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:build/cucumber",
    "junit:build/junit-report.xml"}, features = "src/test/resources/Calculator.feature")
public class CalculatorFeatureTest {

}
