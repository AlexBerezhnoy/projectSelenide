package io.react.realworld;

import com.hillel.auto.config.UserConfig;
import com.hillel.auto.page.object.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    private LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest() {
        String userName = UserConfig.getInstance().userName();
        String email = UserConfig.getInstance().userEmail();
        String password = UserConfig.getInstance().userPassword();

        loginPage
                .openPage()
                .login(email, password)
                .isUserLoggedIn(userName);
    }
}
