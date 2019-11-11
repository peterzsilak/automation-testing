package com.poc.automation.testing.driver.manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SingletonChromeDriverManager implements SingletonDriver {

    @Value("${headless}")
    Boolean headlessModeIsOn;
    
    private WebDriver webDriver;

    @Override
    public WebDriver getWebDriverInstance() {

        if (webDriver == null) {

            WebDriverManager.chromedriver().setup();

            if (headlessModeIsOn) {
                ChromeOptions options = setHeadlessMode();
                return new ChromeDriver(options);
            }

            return new ChromeDriver();
        }

        return webDriver;
    }

    private ChromeOptions setHeadlessMode() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
        return options;
    }

}
