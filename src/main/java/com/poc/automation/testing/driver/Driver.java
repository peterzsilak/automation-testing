package com.poc.automation.testing.driver;

import org.openqa.selenium.WebDriver;

public interface Driver {

    WebDriver getWebDriverInstance();

    void closeWebDriverInstance();

}
