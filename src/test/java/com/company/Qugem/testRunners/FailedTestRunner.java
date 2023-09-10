package com.company.Qugem.testRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com/company/Qugem/stepDefinitions", "com/company/Qugem/hooks"},
        features = "@target/rerun.txt"
)
public class FailedTestRunner {
}
