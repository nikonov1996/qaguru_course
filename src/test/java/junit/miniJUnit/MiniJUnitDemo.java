package junit.miniJUnit;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MiniJUnitDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        DemoTest demoTest = new DemoTest();
        System.out.println(Arrays.toString(demoTest.getClass().getMethods()));
        Method[] methods = demoTest.getClass().getDeclaredMethods();
        for (Method method : methods) {
            Test annotation = method.getAnnotation(Test.class);
            if (annotation != null) {
                DemoTest instance = DemoTest.class.getConstructor().newInstance();
                try {
                    method.invoke(instance);
                } catch (Exception e) {
                    System.out.println(method.getName() + " TEST BROKEN!");
                    return;
                }
                System.out.println(method.getName() + " TEST PASSED!");
            }
        }

    }
}