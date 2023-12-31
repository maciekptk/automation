package com.example.test.automation.selenium.tests;

import com.example.test.automation.annotations.LazyAutowired;
import com.example.test.automation.selenium.pages.FakePricingPage;
import com.example.test.automation.selenium.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FakePricingPageTest extends BaseTest {

  @LazyAutowired
  HomePage homePage;
  @LazyAutowired
  FakePricingPage fakePricingPage;

  @Test
  void shouldOpenFakePricingPageAndCheckHeader() {
    homePage.goToHomePage()
        .clickFakePricingPageLink();

    assertThat(fakePricingPage.isAt()).isTrue();
  }
}
