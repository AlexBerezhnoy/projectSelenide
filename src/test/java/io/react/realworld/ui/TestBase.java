package io.react.realworld.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.hillel.auto.config.BrowserConfiguration;
import com.hillel.auto.page.object.HomePage;
import com.hillel.auto.page.object.RegistrationPage;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class TestBase {

    private static final BrowserConfiguration browserConfiguration= ConfigFactory.create(BrowserConfiguration.class);

    static {
        Configuration.baseUrl = "https://react-redux.realworld.io/";
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.browser = browserConfiguration.remoteChrome();
    }

    @BeforeMethod
    public void setUp() {
        open(Configuration.baseUrl);
    }



       protected void checkPage(String pageHeader) {
        WebElement singUpHeader =$(".auth-page h1");
        assertThat(singUpHeader.getText()).isEqualTo(pageHeader);
    }

    protected RegistrationPage singFormIsDisplaying() {
        $(".auth-page form").shouldBe(Condition.visible);
        return new RegistrationPage();
    }

    protected WebElement emailField() {
        return $(" input[type='email']");
    }

    protected WebElement passwordField() {
        return $(".auth-page form input[type='password']");
    }

    protected void clickSingInButton() {
        $(".auth-page form button[type='submit']").click();
    }

    protected void inputText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void userShouldBeLoggedIn(String userName) {
        WebElement userInfo = $("[href='#@" +userName+"']").shouldBe(Condition.visible.because("User not logged in!"));
        new HomePage();
    }

    protected void clickLoginButton() {
        $("a[href='#login']").click();
    }

    protected void clickUserButton (String userName){
        $("[href='#@" +userName+"']").click();
    }

    protected void clickRegistrationButton() {
        $("a[href='#register']").click();
    }
}
