package reqresin;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import reqresin.models.lombokModels.LoginRequestLombokModel;
import reqresin.models.lombokModels.LoginResponseLombokModel;
import reqresin.models.pojoModels.LoginRequestModel;
import reqresin.models.pojoModels.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static reqresin.specifications.loginSpec.LoginSpec.loginRequestSpecification;
import static reqresin.specifications.loginSpec.LoginSpec.loginResponseSpecification;

public class AuthorizationTest {
    /**
     * Пример теста без использования моделей для описания тела запроса/ответа,
     * а также без использования спецификаций для избежания дублирования кода
     */
    @Test
    public void testThatSuccessLogin(){
        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";
        given()
                .log().all().
                contentType(ContentType.JSON).
                body(body).
        when()
                .post("https://reqres.in/api/login").
        then()
                .log().body().log().status()
                .statusCode(200)
                .body(
                        "token",
                        is("QpwL5tke4Pnpja7X4"));

    }

    /**
     * Пример теста с использованием спецификаций и классов моделей POJO,
     * а также добавлены отчеты Аллюра
     */
    @Test
    public void testThatSuccessLoginWithPojoModels(){
        LoginRequestModel body = new LoginRequestModel()
                .withEmail("eve.holt@reqres.in")
                .withPassword("cityslicka");

        LoginResponseModel expectedResponseBody = new LoginResponseModel().withToken("QpwL5tke4Pnpja7X4");

        LoginResponseModel actualResponseBody = given(loginRequestSpecification)
                .body(body).
                when()
                .post("/login").
                then()
                .spec(loginResponseSpecification)
                .extract().body().as(LoginResponseModel.class);

        assertThat(
                expectedResponseBody.getToken())
                .isEqualTo(actualResponseBody.getToken());


    }

    /**
     * Пример теста с использованием спецификаций и классов моделей с библиотекой lombok,
     * а также добавлены отчеты Аллюра
     */
    @Test
    public void testThatSuccessLoginWithLombokModels(){
        LoginRequestLombokModel body = new LoginRequestLombokModel();
                body.setEmail("eve.holt@reqres.in");
                body.setPassword("cityslicka");

        LoginResponseLombokModel expectedResponseBody = new LoginResponseLombokModel();
                expectedResponseBody.setToken("QpwL5tke4Pnpja7X4");

        LoginResponseModel actualResponseBody = given(loginRequestSpecification)
                .body(body).
                when()
                .post("/login").
                then()
                .spec(loginResponseSpecification)
                .extract().body().as(LoginResponseModel.class);

        assertThat(
                expectedResponseBody.getToken())
                .isEqualTo(actualResponseBody.getToken());


    }
}
