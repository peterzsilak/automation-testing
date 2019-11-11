package com.poc.automation.testing.stepdefinition;

import com.poc.automation.testing.BaseTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefs extends BaseTest {

    @Before
    public void setup(){
        logger.info("Webdriver started to initialize...");
        webDriver = driverManager.getDriver();
    }

    @After
    public void teardown(){
        driverManager.closeDriver(webDriver);
        logger.info("Webdriver stopped.");
    }

    @Given("the Google search page")
    public void the_Google_search_page() {
        webDriver.get("http://google.com");
        assertEquals("Google", webDriver.getTitle());
    }

    @When("user is searching for a {string}")
    public void user_is_searching_for_a(String searchedWord) {
        WebElement searchField = webDriver.findElement(By.name("q"));
        searchField.sendKeys(searchedWord);
        searchField.submit();
    }

}
