package io.react.realworld.ui;

import com.hillel.auto.config.UserConfig;
import com.hillel.auto.page.object.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class NewPostTest extends TestBase {
    String title = "New Test Post";
    String about = "For testing";
    String postText = "Post For testing";
    String tags = "Tags!";
    private LoginPage loginPage = new LoginPage();
    String userName = UserConfig.getInstance().userName();
    String email = UserConfig.getInstance().userEmail();
    String password = UserConfig.getInstance().userPassword();
    private HomePage homePage = new HomePage();

    @BeforeMethod
    public void loginTest() {
        loginPage
                .openPage()
                .login(email, password).isUserLoggedIn(userName);
    }


//    @AfterMethod
//    public void cleanData() {
//        articleService.deleteArticle(article.getSlug());
//    }

    @Test(priority = 1 )
    public void createPost () {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE MMM dd yyyy").withLocale(Locale.ENGLISH);
        String nowDate = date.format(formatter);
        NewPostPage newPostPage = homePage.clickNewPost();
        newPostPage.inputArticleTitle(title);
        newPostPage.inputWhatArticleAbout(about);
        newPostPage.inputArticle(postText);
        newPostPage.inputTags(tags);
        ArticleDetailsPage articleDetailsPage = newPostPage.clickPublishArticleBtn();
        articleDetailsPage.getPostTextAndValidate(postText);
        String datePost = articleDetailsPage.getDatePost().getText();
        assertThat(datePost).isEqualTo(nowDate);
    }

    @Test(priority = 3 )
    public void editPost () {
        ProfilePage profilePage = homePage.clickProfile();
        profilePage.clickMyArticles();
        ArticleDetailsPage articleDetailsPage = profilePage.clickLastPost();
        NewPostPage newPostPage = articleDetailsPage.clickEditButton();
        postText = postText+" EDIT";
        newPostPage.inputArticleTitle(title);
        newPostPage.inputWhatArticleAbout(about);
        newPostPage.inputArticle(postText);
        newPostPage.inputTags(tags);
        articleDetailsPage = newPostPage.clickPublishArticleBtn();
        articleDetailsPage.getPostTextAndValidate(postText);

    }

    @Test (priority = 4 )
    public void deletePost () {
        ProfilePage profilePage = homePage.clickProfile();
        profilePage.clickMyArticles();
        ArticleDetailsPage articleDetailsPage = profilePage.clickLastPost();
        homePage = articleDetailsPage.clickDeleteButton();
        profilePage = homePage.clickProfile();
        profilePage.getMyArticlePreviewText();
    }

    @Test (priority = 2 )
    public void checkArticleSize() {
        ProfilePage profilePage = homePage.clickProfile();
        profilePage.getArticleSizeAndValidateCountOfArticles(0);
    }

}