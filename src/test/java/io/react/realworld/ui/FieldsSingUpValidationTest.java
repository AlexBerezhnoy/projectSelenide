package io.react.realworld.ui;

import com.hillel.auto.page.object.RegistrationPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.Random;
@Feature("Authorization feature")
@Story("Login story")
public class FieldsSingUpValidationTest extends TestBase {
    String user = "TestUser"+new Random().nextInt(10000);
    String email = user+"@rambler.ru".toLowerCase();
    String password = "qwerty123";

    @Severity(SeverityLevel.TRIVIAL)
    @TmsLink("BUG3521")
    @Test
    public void userNameBlankValidationTest () {
        clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.inputUser(" ");
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.clickSingInButton();
        registrationPage.isRigthErrorDisplaying("username can't be blankis too short (minimum is 1 character)is too long (maximum is 20 characters)");
    }

    @Severity(SeverityLevel.TRIVIAL)
    @TmsLink("BUG3522")
    @Test
    public void emailBlankValidationTest () {
        clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.inputUser(user);
        registrationPage.inputEmail(" ");
        registrationPage.inputPassword(password);
        registrationPage.clickSingInButton();
        registrationPage.isRigthErrorDisplaying("email can't be blank");

    }

    @Severity(SeverityLevel.TRIVIAL)
    @TmsLink("BUG3523")
    @Test
    public void emailValidationTest () {
        clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.inputUser(user);
        registrationPage.inputEmail("wqweq@v");
        registrationPage.inputPassword(password);
        registrationPage.clickSingInButton();
        registrationPage.isRigthErrorDisplaying("email is invalid");

    }

    @Severity(SeverityLevel.TRIVIAL)
    @TmsLink("BUG3524")
    @Test
    public void passwordShortValidationTest () {
        clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.inputUser(user);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword("1");
        registrationPage.clickSingInButton();
        registrationPage.isRigthErrorDisplaying("password is too short (minimum is 8 characters)");

    }

    @Severity(SeverityLevel.TRIVIAL)
    @TmsLink("BUG3525")
    @Test
    public void passwordBlankValidationTest () {
        clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.inputUser(user);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(" ");
        registrationPage.clickSingInButton();
        registrationPage.isRigthErrorDisplaying("password can't be blank");
    }
}
