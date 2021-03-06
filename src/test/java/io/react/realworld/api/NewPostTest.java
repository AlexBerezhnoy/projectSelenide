package io.react.realworld.api;

import com.hillel.auto.listener.LogListener;
import com.hillel.auto.model.Article;
import com.hillel.auto.model.ArticleResponse;
import com.hillel.auto.model.User;
import com.hillel.auto.service.UserService;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
@Listeners(LogListener.class)
public class NewPostTest {
    private UserService userService = new UserService();
    private User user;
    Article newArticle;

    @BeforeClass
    public void setUp () {
        user = userService.userRegistration();
        RestAssured.baseURI = "https://conduit.productionready.io";
        RestAssured.basePath = "/api";
        RestAssured.requestSpecification =
                new RequestSpecBuilder()
                        .setAccept(ContentType.JSON)
                        .setContentType(ContentType.JSON)
                        .addHeader("Authorization", "Token " + user.getToken())
                        .log(LogDetail.ALL)
                        .build();

    }

    @Test
    public void newArticleTest() {

        Article article = new Article();
        article.setTitle("First article");
        article.setDescription("Super Article desc");
        article.setBody("test hoho");
        article.setTagList(Arrays.asList("test", "hoho"));

        newArticle = RestAssured
                .given()
                .body(article)
                .when()
                .post("/articles")
                .then()
                .statusCode(200)
                .extract().body()
                .as(ArticleResponse.class)
                .getArticle();

        System.out.println(newArticle);
    }

    @Test
    public void getArticle() {
        RestAssured
                .given()
                .when()
                .get("/articles/"+getSlug())
                .then()
                .statusCode(200)
                .extract().body()
                .as(ArticleResponse.class)
                .getArticle();

        System.out.println(newArticle);
    }

    @Test
    public void delArticle() {
        RestAssured
                .given()
                .when()
                .delete("/articles/"+getSlug())
                .then()
                .statusCode(200);

    }

    @Test
    public void putArticle() {
        RestAssured
                .given()
                .when()
                .get("/articles/"+getSlug())
                .then()
                .statusCode(200)
                .extract().body()
                .as(ArticleResponse.class)
                .getArticle();

        System.out.println(newArticle);
    }

    public String getSlug() {
        newArticle = createArticle ();
        return  newArticle.getSlug();
    }

    public Article createArticle () {

        Article article = new Article();
        article.setTitle("First article");
        article.setDescription("Super Article desc");
        article.setBody("test hoho");
        article.setTagList(Arrays.asList("test", "hoho"));

        newArticle = RestAssured
                .given()
                .body(article)
                .when()
                .post("/articles")
                .then()
                .statusCode(200)
                .extract().body()
                .as(ArticleResponse.class)
                .getArticle();
        return newArticle;
    }
}
