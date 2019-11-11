package com.poc.automation.testing;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseTest {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected WebDriver webDriver;

}
