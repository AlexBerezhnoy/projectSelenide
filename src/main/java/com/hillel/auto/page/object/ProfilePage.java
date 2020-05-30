package com.hillel.auto.page.object;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage extends BasePage {
    private By myArticle = By.cssSelector(".articles-toggle  li:nth-child(1) > a");

    private By article = By.cssSelector(".article-preview");
    private By settingBtn = By.cssSelector("a[href = '#settings']");
    private By userInfo = By.cssSelector(".user-info");
    private By getMyArticle = By.cssSelector(".article-preview");


    public ProfilePage getArticleSizeAndValidateCountOfArticles (int countArticles){
         $$(article).shouldBe(CollectionCondition.sizeGreaterThan(countArticles));
        return this;
    }


    public void clickMyArticles() {
        $(myArticle).click();
    }

    public SettingPage clickSettingButton () {
        $(settingBtn).click();
        return new SettingPage();
    }

    public ArticleDetailsPage clickLastPost () {
        $$(article).get(0).click();
        return new ArticleDetailsPage();
    }

    public ProfilePage profilePageIsDisplayed () {
       $(userInfo).shouldBe(Condition.visible.because("This isn't Profile Page!"));
        return this;
    }

    public ProfilePage getMyArticlePreviewText () {
        $(getMyArticle).shouldHave(Condition.exactText("No articles are here... yet."));
        return this;
    }

}