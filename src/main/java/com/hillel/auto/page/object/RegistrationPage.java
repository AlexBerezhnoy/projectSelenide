package com.hillel.auto.page.object;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends BasePage {

    private By emailInputField = By.cssSelector(".auth-page form input[type='email']");
    private By userInputField = By.cssSelector(".auth-page form input[type='email']");
    private By passwordInputField = By.cssSelector(".auth-page form input[type='password']");
    private By signInBtn = By.cssSelector(".auth-page form button[type='submit']");
    private By pageTitle = By.cssSelector(".auth-page h1");
    private By errors = By.cssSelector(".error-messages>li");

    public void inputUser(String username) {
        WebElement userField = $(userInputField);
        inputText(userField, username);
    }
    public void inputEmail(String email) {
        WebElement emailField = $(emailInputField);
        inputText(emailField, email);
    }

    public void inputPassword(String password) {
        WebElement passwordField = $(passwordInputField);
        inputText(passwordField, password);
    }

    public String getPageTitle() {
        return $(pageTitle).getText();
    }

    public void clickSingInButton() {
        WebElement signInButton = $(signInBtn);
        signInButton.click();
    }

    public RegistrationPage isRigthErrorDisplaying (String errorText) {
        $(errors).shouldHave(Condition.exactText(errorText));
        return this;
    }

}