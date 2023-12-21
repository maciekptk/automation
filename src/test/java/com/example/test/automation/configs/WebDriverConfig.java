package com.example.test.automation.configs;

import com.example.test.automation.annotations.LazyConfiguration;
import com.example.test.automation.annotations.WebdriverScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

@LazyConfiguration
public class WebDriverConfig {
  
  @WebdriverScopeBean
  @ConditionalOnMissingBean
  public WebDriver chromeDriver() {
    return new ChromeDriver();
  }

}
