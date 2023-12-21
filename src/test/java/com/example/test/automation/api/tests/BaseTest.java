package com.example.test.automation.api.tests;

import com.example.test.automation.annotations.LazyAutowired;
import com.example.test.automation.annotations.RestAssuredTest;
import org.springframework.context.ApplicationContext;

@RestAssuredTest
public class BaseTest {

  @LazyAutowired
  public ApplicationContext applicationContext;
}
