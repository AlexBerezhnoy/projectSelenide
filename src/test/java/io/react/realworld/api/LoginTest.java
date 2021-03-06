package io.react.realworld.api;

import com.hillel.auto.listener.LogListener;
import com.hillel.auto.model.User;
import com.hillel.auto.utils.UserData;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
@Feature("Authorization feature")
@Story("Login story")
@Listeners(LogListener.class)
public class LoginTest {
    private User user = UserData.defaultUser();
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("BUG6245")
    @Test
    public void loginTest() {

        RestAssured
                .given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body("{\n"+
                        "\"user\": {\n"+
                        "\"email\": \""+user.getEmail()+"\",\n"+
                        "\"password\": \""+user.getPassword()+"\"\n"+
                        "}\n"+"}")
                .when()
                    .post("https://conduit.productionready.io/api/users/login")
                .then()
                    .statusCode(200)
                    .body("user.email", equalTo(user.getEmail().toLowerCase()))
                    .body("user.username", equalTo(user.getUsername()))
                    .body("user.token", notNullValue())
                .log().all();
    }
}