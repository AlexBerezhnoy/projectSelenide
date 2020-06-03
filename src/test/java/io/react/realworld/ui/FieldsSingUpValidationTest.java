package io.react.realworld.ui;

import com.hillel.auto.page.object.RegistrationPage;
import org.testng.annotations.Test;

import java.util.Random;

public class FieldsSingUpValidationTest extends TestBase {
    String user = "TestUser"+new Random().nextInt(10000);
    String email = user+"@rambler.ru".toLowerCase();
    String password = "qwerty123";

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
