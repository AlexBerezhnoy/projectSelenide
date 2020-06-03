package io.react.realworld.ui;

import com.hillel.auto.config.UserConfig;
import com.hillel.auto.model.User;
import com.hillel.auto.page.object.*;
import com.hillel.auto.utils.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginUserNavigationTest extends TestBase  {
    private User user = UserData.defaultUser();
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

    @Test
    public void NewPostPageTest () {
        NewPostPage newPostPage = homePage.clickNewPost();
        newPostPage.newPostPageIsDisplayed();
    }

    @Test
    public void UserHomePageTest () {
        homePage.yourFeedButtonIsDisplaying();
        homePage.globalFeedButtonIsDisplaying();
    }

    @Test
    public void SettingsPageTest () {
        ProfilePage profilePage = homePage.clickProfile();
        SettingPage settingPage = profilePage.clickSettingButton();
        settingPage.settingPageIsDisplayed();
    }

    @Test
    public void UserPageTest () {
        ProfilePage profilePage = homePage.clickProfile();
        profilePage.profilePageIsDisplayed();
    }
}
