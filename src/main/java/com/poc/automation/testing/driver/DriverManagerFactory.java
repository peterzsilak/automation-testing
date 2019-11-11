package com.poc.automation.testing.driver;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverManagerFactory {

    @Autowired
    SingletonChromeDriver singletonChromeDriver;

    public static WebDriver getDriver(DriverTypes driverType) {

        WebDriver webDriver;

        switch (driverType) {

            case CHROME:
                webDriver = new SingletonChromeDriver().getWebDriverInstance();
                break;

            default:
                webDriver = new SingletonChromeDriver().getWebDriverInstance();
                break;
        }
        return webDriver;
    }

    public static void closeDriver(WebDriver webDriver){
        webDriver.quit();
    }

}
