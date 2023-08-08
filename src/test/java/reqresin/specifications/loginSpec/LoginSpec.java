package reqresin.specifications.loginSpec;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.notNullValue;
import static reqresin.helpers.CustomAllureListener.withCustomTemplates;

public class LoginSpec {

    public static RequestSpecification loginRequestSpecification = with()
            .filter(new AllureRestAssured())
            .log().uri()
            .log().headers()
            .log().body()
            .contentType(ContentType.JSON)
            .baseUri("https://reqres.in")
            .basePath("/api");

    public static ResponseSpecification loginResponseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .expectBody("token",notNullValue())
            .build();
}
