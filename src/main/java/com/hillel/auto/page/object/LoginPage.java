package com.hillel.auto.page.object;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private By emailInputField = By.cssSelector(".auth-page form input[type='email']");
    private By passwordInputField = By.cssSelector(".auth-page form input[type='password']");
    private By signInBtn = By.cssSelector(".auth-page form button[type='submit']");
    private By pageTitle = By.cssSelector(".auth-page h1");
    private By errors = By.cssSelector(".error-messages>li");
    private By loginLink = byAttribute("href", "#login");


    public HomePage login(String email, String password) {
        System.out.println("Login as user");
        inputEmail(email);
        inputPassword(password);
        return clickSingInButton();
    }

    public void inputEmail(String email) {
        $(emailInputField).setValue(email);
    }

    public void inputPassword(String password) {
        $(passwordInputField).setValue(password);
    }

    public String getPageTitle() {
        return $(pageTitle).getText();
    }

    public HomePage clickSingInButton() {
        $(signInBtn).click();
        return new HomePage();
    }

    public LoginPage isRigthErrorDisplaying (String errorText) {
        $(errors).shouldHave(Condition.exactText(errorText));
        return this;
    }

    public LoginPage openPage() {
        $(loginLink).shouldBe(Condition.visible).click();
        return this;
    }
}