package com.poc.automation.testing;

import com.poc.automation.testing.driver.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseTest {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected DriverManagerFactory driverManager;

    protected WebDriver webDriver;

}
