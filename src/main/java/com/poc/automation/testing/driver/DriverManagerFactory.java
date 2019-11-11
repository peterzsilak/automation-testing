package com.poc.automation.testing.driver;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DriverManagerFactory {

    @Value("${drivertype}")
    DriverTypes driverType;

    @Autowired
    SingletonChromeDriver singletonChromeDriver;

    @Autowired
    SingletonFirefoxDriver singletonFirefoxDriver;

    private WebDriver webDriver;

    public WebDriver getDriver() {

        switch (driverType) {
            case CHROME:
                webDriver = singletonChromeDriver.getWebDriverInstance();
                break;
            case FIREFOX:
                webDriver = singletonFirefoxDriver.getWebDriverInstance();
                break;
            default:
                webDriver = singletonChromeDriver.getWebDriverInstance();
                break;
        }
        return webDriver;
    }

    public static void closeDriver(WebDriver webDriver) {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
