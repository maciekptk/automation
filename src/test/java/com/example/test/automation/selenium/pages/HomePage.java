package com.example.test.automation.selenium.pages;

import com.example.test.automation.annotations.LazyComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class HomePage extends BasePage {

  @FindBy(css = "#Automation_Practice")
  public WebElement homePageHeader;
  @FindBy(css = "#main-content .et_pb_text_inner [href*='fake-pricing-page']")
  public WebElement fakePricingPageLink;
  @Autowired
  FakePricingPage fakePricingPage;
  @Value("${selenium.url}")
  String baseUrl;

  public HomePage goToHomePage() {
    driver.get(baseUrl);
    return this;
  }

  public FakePricingPage clickFakePricingPageLink() {
    click(fakePricingPageLink);
    return fakePricingPage;
  }

  @Override
  public boolean isAt() {
    return wait.until(element -> homePageHeader.isDisplayed());
  }
}
