package io.react.realworld.ui;

import com.hillel.auto.config.UserConfig;
import com.hillel.auto.page.object.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;
@Feature("Authorization feature")
@Story("Login story")
public class LoginTest extends TestBase {

    private LoginPage loginPage = new LoginPage();
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("BUG6245")
    @Test
    public void loginTest() {
        String userName = UserConfig.getInstance().userName();
        String email = UserConfig.getInstance().userEmail();
        String password = UserConfig.getInstance().userPassword();


        loginPage
                .openPage()
                .login(email, password)
                .isUserLoggedIn(userName+"  ");
    }
}
