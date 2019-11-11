package com.poc.automation.testing.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SingletonFirefoxDriver {

    @Value("${headless}")
    Boolean headlessModeIsOn;

    private WebDriver webDriver;

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
