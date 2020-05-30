package com.hillel.auto.page.object;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected void inputText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

//    protected void inputText(By locator, String text) {
//        element.clear();
//        element.sendKeys(text);
//    }
    static {
      Configuration.baseUrl = "https://react-redux.realworld.io/";
    }
}
