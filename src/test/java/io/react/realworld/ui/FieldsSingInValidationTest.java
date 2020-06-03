package io.react.realworld.ui;

import com.hillel.auto.page.object.LoginPage;
import org.testng.annotations.Test;

import java.util.Random;

public class FieldsSingInValidationTest extends TestBase{


    String email = "testuser"+new Random().nextInt(10000)+"@rambler.ru";
    String password = "qwerty123";

    @Test
    public void emailBlankValidationTest () {
        clickLoginButton();
        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail(" ");
        loginPage.inputPassword(password);
        loginPage.clickSingInButton();

        loginPage.isRigthErrorDisplaying("email or password is invalid");

    }

    @Test
    public void emailWrongValidationTest () {
        clickLoginButton();
        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail(" "+email);
        loginPage.inputPassword(password);
        loginPage.clickSingInButton();
        loginPage.isRigthErrorDisplaying("email or password is invalid");

    }

    @Test
    public void passwordWrongValidationTest () {
        clickLoginButton();
        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail(email);
        loginPage.inputPassword(" "+password);
        loginPage.clickSingInButton();

        loginPage.isRigthErrorDisplaying("email or password is invalid");

    }

    @Test
    public void passwordBlankValidationTest () {
        clickLoginButton();
        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail(email);
        loginPage.inputPassword(" ");
        loginPage.clickSingInButton();
        loginPage.isRigthErrorDisplaying("email or password is invalid");
    }
}
