package com.hillel.auto.page.object;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private By profileBtn = By.xpath("//*[@class='user-pic']/..");
    private By newPostBtn = By.cssSelector("[href='#editor']");
    private By yourFeedBtn = By.cssSelector(".feed-toggle li:nth-child(1) > a");
    private By globalFeedBtn = By.cssSelector(".feed-toggle li:nth-child(2) > a");


    public HomePage isUserLoggedIn(String userName) {
        $("[href='#@" +userName+"']").shouldBe(Condition.visible.because("User not logged in!"));
        return this;
    }

    public NewPostPage clickNewPost() {
        $(newPostBtn).click();
        return new NewPostPage();
    }

    public ProfilePage clickProfile () {
        $(profileBtn).click();
        return new ProfilePage();
    }

    public WebElement yourFeedButton () {
        return $(yourFeedBtn);
    }

    public HomePage yourFeedButtonIsDisplaying() {
        $(yourFeedBtn).shouldBe(Condition.visible.because("This isn't Home Page!"));
        return this;
    }

    public HomePage globalFeedButtonIsDisplaying() {
        $(globalFeedBtn).shouldBe(Condition.visible.because("This isn't Home Page!"));
        return this;
    }

    public WebElement globalFeedButton () {
        return $(globalFeedBtn);
    }
}
