package junit;

import org.junit.jupiter.api.*;

public class firstJunitTest {

    @BeforeEach
    void beforeEach(){
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("afterEach");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("AfterAll");
    }



    @Test
    void firstJUnitTest(){
        System.out.println("Это тест firstJUnitTest");
    }

    @Test
    void secondJUnitTest(){
        System.out.println("Это тест secondJUnitTest");
    }
}
