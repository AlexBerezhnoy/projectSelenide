package io.react.realworld.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.hillel.auto.config.BrowserConfiguration;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class RemoteWebDriverTest {

    private BrowserConfiguration browserConfiguration = ConfigFactory.create(BrowserConfiguration.class);

    @SneakyThrows
    @Test
    public void signInValidationTest() {
        Configuration.baseUrl = "https://react-redux.realworld.io/";
        Configuration.browser = browserConfiguration.remoteChrome();

        open(Configuration.baseUrl);

        $("[href='#register']").click();
        $("[type='submit']").click();
        ElementsCollection errorMessages = $$(".error-messages>li");
        errorMessages.shouldHaveSize(3);
    }
}
