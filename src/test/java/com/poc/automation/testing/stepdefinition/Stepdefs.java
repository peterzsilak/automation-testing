package com.poc.automation.testing.stepdefinition;

import com.poc.automation.testing.BaseTest;
import com.poc.automation.testing.driver.DriverManagerFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.poc.automation.testing.driver.DriverTypes.CHROME;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Stepdefs extends BaseTest {

    @Before
    public void setup(){
        logger.info("Webdriver started to initialize...");
        DriverManagerFactory.getDriver(CHROME);
        webDriver = DriverManagerFactory.getDriver(CHROME);
    }

    @After
    public void teardown(){
        DriverManagerFactory.closeDriver(webDriver);
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
