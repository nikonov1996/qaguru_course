package reqresin;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reqresin.models.lombokModels.*;

import java.util.Arrays;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static reqresin.specifications.userSpec.UserSpec.*;

public class UserTest extends TestBase{
    @Test
    public void testThatSuccessGetUserById(){

        User expectedUser = step("Создание ожидаемого тестового пользователя", ()-> User.builder()
                .id("2")
                .firstName("Janet")
                .lastName("Weaver")
                .email("janet.weaver@reqres.in")
                .avatar("https://reqres.in/img/faces/2-image.jpg")
                .build());

        UserResponseModel expectedResponse = step("Формирование ожидаемого ответа сервера",()-> UserResponseModel.builder()
                .data(expectedUser)
                .build());

        UserResponseModel actualResponseBody = step("Получение пользователя по айди: " + expectedUser.getId(),()->
                when()
                .get("/users/" + expectedUser.getId() ).
                then()
                .spec(userResponseSpecification)
                .extract().as(UserResponseModel.class));

        step("Сравнение ожидаемого пользователя с полученым из ответа сервера",()->
        System.out.println(actualResponseBody.equals(expectedResponse)));

    }

    @Test
    public void testThatSuccessGetUsersList(){
        UserListResponseModel actualResponse = step("Получение списка пользователей по номеру страницы ",()->
                when()
                        .get("/users?page" + 2 ).
                        then()
                        .spec(userListSuccessResponseSpecification)
                        .extract().as(UserListResponseModel.class));

        Assertions.assertTrue(actualResponse.getData().length >= 5);
    }

    @Test
    public void testThatNoUserByNotExistenId(){

        step("Получение пользователя по несуществующему айди" ,()->
                when()
                        .get("/users/" + 50 ).
                        then()
                        .spec(userNoSuccessResponseSpecification)
                        .body("isEmpty()",is(true)));



    }
}
