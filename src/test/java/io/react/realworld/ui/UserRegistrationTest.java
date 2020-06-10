package io.react.realworld.ui;

import com.codeborne.selenide.CollectionCondition;
import com.hillel.auto.model.User;
import com.hillel.auto.utils.UserData;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
@Feature("Authorization feature")
@Story("Registration story")
public class UserRegistrationTest extends TestBase {

    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("BUG3545")
    @Test
    public void registrationTest() {
        clickRegistrationButton();
        checkPage("Sign Up");
        singFormIsDisplaying();
        User user = UserData.randomUser();
        inputText(userNameFiled(), user.getUsername());
        inputText(emailField(), user.getEmail());
        inputText(passwordField(), user.getPassword());
        clickSingInButton();
        userShouldBeLoggedIn(user.getUsername());
    }

    @Severity(SeverityLevel.NORMAL)
    @TmsLink("BUG3546")
    @Test
    public void validationRegistrationForm() {
        clickRegistrationButton();

        checkPage("Sign Up");

        clickSingInButton();

        $$(".error-messages li").shouldHaveSize(3);
        $$(".error-messages li").shouldHave(CollectionCondition.texts("email can't be blank",
                "password can't be blank",
                "username can't be blankis too short (minimum is 1 character)is too long (maximum is 20 characters)"));
    }
    private WebElement userNameFiled() {
        return $(".auth-page form input[type='text']");
    }
}