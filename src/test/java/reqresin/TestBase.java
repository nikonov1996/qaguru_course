package reqresin;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import reqresin.specifications.BaseSpec;

import static reqresin.specifications.BaseSpec.installSpecification;

public class TestBase {
    @BeforeAll
    public static void before(){
        installSpecification();
    }
}
