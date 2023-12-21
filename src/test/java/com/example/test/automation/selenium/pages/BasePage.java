package com.example.test.automation.selenium.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BasePage {

  @Autowired
  protected WebDriver driver;
  @Autowired
  protected WebDriverWait wait;
  @Autowired
  protected JavascriptExecutor javascriptExecutor;

  @PostConstruct
  private void init() {
    PageFactory.initElements(this.driver, this);
  }

  public abstract boolean isAt();

  public void waitElement(WebElement webElement) {
    wait.until(ExpectedConditions.visibilityOf(webElement));
  }

  public void waitElements(List<WebElement> webElements) {
    wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
  }

  public void click(WebElement webElement) {
    webElement.click();
  }

  public void jsClick(WebElement webElement) {
    javascriptExecutor.executeScript("arguments[0].click();", wait.until(ExpectedConditions.visibilityOf(webElement)));
  }

  public void writeText(WebElement webElement, String text) {
    waitElement(webElement);
    webElement.sendKeys(text);
  }

  public String readText(WebElement webElement) {
    waitElement(webElement);
    return webElement.getText();
  }
}
