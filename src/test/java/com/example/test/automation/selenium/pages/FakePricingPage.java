package com.example.test.automation.selenium.pages;

import com.example.test.automation.annotations.LazyComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@LazyComponent
public class FakePricingPage extends BasePage {

  @FindBy(css = ".et_pb_text_inner h1")
  public WebElement header;

  @Override
  public boolean isAt() {
    waitElement(header);
    return readText(header).contains("Pick a Plan");
  }
}
