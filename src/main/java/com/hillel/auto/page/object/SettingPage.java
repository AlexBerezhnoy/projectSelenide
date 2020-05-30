package com.hillel.auto.page.object;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SettingPage extends BasePage {

    private By urlField = By.cssSelector(".form-group:nth-child(1)>input");
    private By userField = By.cssSelector(".form-group:nth-child(2)>input");
    private By shortBioField = By.cssSelector(".form-group:nth-child(3)>textarea");
    private By emailField = By.cssSelector(".form-group:nth-child(4)>input");
    private By newPasswordField = By.cssSelector(".form-group:nth-child(5)>input");
    private By updateSettingBtn = By.cssSelector("form button");
    private By settingPage = By.cssSelector(".settings-page form");

    public SettingPage settingPageIsDisplayed () {
        $(settingPage).shouldBe(Condition.visible.because("This isn't Setting Page!"));
        return this;
    }

}