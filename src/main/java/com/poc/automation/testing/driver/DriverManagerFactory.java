package com.poc.automation.testing.driver;

import com.poc.automation.testing.driver.manager.SingletonChromeDriver;
import com.poc.automation.testing.driver.manager.SingletonFirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.poc.automation.testing.driver.DriverTypes.CHROME;
import static com.poc.automation.testing.driver.DriverTypes.FIREFOX;

@Component
public class DriverManagerFactory {

    @Value("${drivertype}")
    DriverTypes driverType;

    @Autowired
    private SingletonChromeDriver singletonChrome;

    @Autowired
    private SingletonFirefoxDriver singletonFirefox;

    public WebDriver getDriver() {

        if ( driverType == FIREFOX ) {
            return singletonFirefox.getWebDriverInstance();
        } else
        if ( driverType == CHROME ) {
            return singletonChrome.getWebDriverInstance();
        } else {
            return singletonChrome.getWebDriverInstance();
        }
    }

    public static void closeDriver(WebDriver webDriver) {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
