package junit.miniJUnit;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;

public class DemoTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Method with annotation @BeforeAll");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Method with annotation @AfterAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Method with annotation @BeforeEach");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("Method with annotation @AfterEach");
    }

    @Test
    public void firstTest(){
        Assertions.assertTrue(3>2);
    }

    @Test
    public void secondTest(){
        Assertions.assertTrue(3>6);
    }

    @Test
    public void thirdTest(){
        Assertions.assertTrue(3>1);
    }
}
