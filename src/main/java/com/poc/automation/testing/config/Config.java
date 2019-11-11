package com.poc.automation.testing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.yml")
@ComponentScan("com.poc.automation.testing")
public class Config {
}
