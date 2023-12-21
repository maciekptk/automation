package com.example.test.automation.selenium.tests;

import com.example.test.automation.annotations.LazyAutowired;
import com.example.test.automation.selenium.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HomePageTest extends BaseTest {

  @LazyAutowired
  HomePage homePage;

  @Test
  void shouldOpenHomePage() {
    homePage.goToHomePage()
        .isAt();

    assertThat(homePage.isAt()).isTrue();
  }
}
