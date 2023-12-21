package com.example.test.automation.selenium.tests;

import com.example.test.automation.annotations.LazyAutowired;
import com.example.test.automation.annotations.SeleniumTest;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

@SeleniumTest
public class BaseTest {

  @LazyAutowired
  public ApplicationContext applicationContext;

  @AfterEach
  public void tearDown() {
    applicationContext.getBean(WebDriver.class)
        .quit();
  }
}
