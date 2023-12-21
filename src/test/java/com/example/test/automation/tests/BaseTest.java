package com.example.test.automation.tests;

import com.example.test.automation.annotations.LazyAutowired;
import com.example.test.automation.annotations.SeleniumTest;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

@SeleniumTest
@Getter
public class BaseTest {

  @LazyAutowired
  public ApplicationContext applicationContext;

  @AfterEach
  public void tearDown() {
    applicationContext.getBean(WebDriver.class)
        .quit();
  }
}
