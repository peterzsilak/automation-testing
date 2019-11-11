package com.poc.automation.testing.driver.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SingletonFirefoxDriverManager implements SingletonDriver {

    @Value("${headless}")
    Boolean headlessModeIsOn;

    private WebDriver webDriver;

    @Override
    public WebDriver getWebDriverInstance() {

        if (webDriver == null) {
            WebDriverManager.firefoxdriver().setup();

            if (headlessModeIsOn){
                FirefoxOptions firefoxOptions = setHeadlessMode();
                return new FirefoxDriver(firefoxOptions);
            }
            return new FirefoxDriver();
        }

        return webDriver;
    }

    private FirefoxOptions setHeadlessMode() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        return firefoxOptions;
    }
}
