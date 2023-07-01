package junit.miniJUnit;

import junit.data.Locale;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class ParametrizedTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Method with annotation @BeforeAll");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Method with annotation @AfterAll");
    }

    @ValueSource(
            strings = {"Allure", "Google", "Habr", "Google"}
    )
    @ParameterizedTest
    public void stringParametrizedTest(String name){
        Assertions.assertTrue(name.length() >5);
    }

    @ValueSource(
            ints = {6, 8, 3, 7, 1 ,2}
    )
    @ParameterizedTest
    public void intParametrizedTest(int number){
        Assertions.assertTrue(number > 5);
    }
}
