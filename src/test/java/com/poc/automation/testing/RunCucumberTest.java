package com.poc.automation.testing;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"classpath:features/"},
        glue = {"com.poc.automation.testing.stepdefinition"},
        tags = {"@wip"}
        )
public class RunCucumberTest {

}
