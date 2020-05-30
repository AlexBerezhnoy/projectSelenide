package com.hillel.auto.page.object;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewPostPage extends BasePage {

    private By titleField = By.cssSelector(".form-group:nth-child(1)>input");
    private By whatAboutField = By.cssSelector(".form-group:nth-child(2)>input");
    private By articleBodyField = By.cssSelector(".form-group:nth-child(3)>textarea");
    private By tagsField = By.cssSelector(".form-group:nth-child(4)>input");
    private By publishArticleBtn = By.cssSelector("[type='button']");
    private By newPostPage = By.cssSelector(".editor-page form");


    public void inputArticleTitle(String title) {
        $(titleField).setValue(title);
    }

    public void inputWhatArticleAbout(String whatAbout) {
        $(whatAboutField).setValue(whatAbout);
    }

    public void inputArticle(String article) {
        $(articleBodyField).setValue(article);
    }

    public void inputTags(String tags) {
        $(tagsField).setValue(tags);
    }

    public ArticleDetailsPage clickPublishArticleBtn() {
        $(publishArticleBtn).click();
        return new ArticleDetailsPage();
    }

    public NewPostPage newPostPageIsDisplayed()
    {
        $(newPostPage).shouldBe(Condition.visible.because("This isn't New Post Page!"));
        return this;
    }


}
