package com.hillel.auto.page.object;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class ArticleDetailsPage extends BasePage {
    private By editPostBtn = By.cssSelector(".article-meta>span>a");
    private By deleteBtn = By.cssSelector(".article-meta button.btn");
    private By title = By.cssSelector(".article-page");
    private By postText = By.cssSelector(".article-content p");
    private By datePost = By.cssSelector("#main > div > div > div.banner > div > div > div > span");


    public boolean isPageOpen () {
        return $(title).isDisplayed();
    }

    public NewPostPage clickEditButton () {
        $(editPostBtn).click();
        return new NewPostPage();
    }

    public HomePage clickDeleteButton () {
        $(deleteBtn).click();
        return new HomePage();
    }
    public ArticleDetailsPage getPostTextAndValidate (String text) {
        $(postText).shouldHave(Condition.exactText(text));
        return this;
    }

    public WebElement getDatePost () {
        return $(datePost);
    }
}
