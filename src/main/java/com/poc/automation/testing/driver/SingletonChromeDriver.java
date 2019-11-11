package com.poc.automation.testing.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

@Component
public class SingletonChromeDriver implements Driver {

    private WebDriver webDriver;

    public SingletonChromeDriver() {
        this.webDriver = getWebDriverInstance();
    }

    public WebDriver getWebDriverInstance() {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeDriver chromeDriver = new ChromeDriver();
            System.out.println("SessionId:" + chromeDriver.getSessionId());
            return chromeDriver;
        }
        return webDriver;
    }

    public void closeWebDriverInstance() {
        if (webDriver != null){
            webDriver.quit();
        }
        webDriver = null;
    }

}
