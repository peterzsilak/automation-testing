package com.poc.automation.testing.driver;

import com.poc.automation.testing.driver.manager.SingletonChromeDriverManager;
import com.poc.automation.testing.driver.manager.SingletonFirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.poc.automation.testing.driver.DriverTypes.*;

@Component
public class DriverManagerFactory {

    @Value("${drivertype}")
    DriverTypes driverType;

    @Autowired
    SingletonChromeDriverManager singletonChromeDriverManager;

    @Autowired
    SingletonFirefoxDriverManager singletonFirefoxDriverManager;

    public WebDriver getDriver() {
        WebDriver webDriver;
        if (driverType == FIREFOX) {
            webDriver = singletonFirefoxDriverManager.getWebDriverInstance();
        } else
        if (driverType == CHROME) {
            webDriver = singletonChromeDriverManager.getWebDriverInstance();
        } else {
            webDriver = singletonChromeDriverManager.getWebDriverInstance();
        }
        return webDriver;
    }

    public static void closeDriver(WebDriver webDriver) {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
