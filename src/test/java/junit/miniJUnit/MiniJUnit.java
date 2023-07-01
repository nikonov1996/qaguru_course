package junit.miniJUnit;

import org.apache.poi.util.ArrayUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static java.lang.String.format;

public class MiniJUnit {

    public static void main(String[] args) throws Exception {

        List<Class> testClasses = new ArrayList<>();
        testClasses.add(ParametrizedTest.class);
        testClasses.add(DemoTest.class);

        testClasses.forEach(testClass -> {
            try {
                TestRunner(
                        testClass
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


    }

    private static Annotation[] getMethodAnnotations(Method method) {
        return new Annotation[]{
                method.getAnnotation(Test.class),
                method.getAnnotation(ParameterizedTest.class),
                method.getAnnotation(MethodSource.class)
        };
    }

    public static void TestRunner(Class<?> testClass) throws Exception {
        System.out.println("***\n");
        fixtureMethodRun(testClass, BeforeAll.class);
        Method[] methods = testClass.getMethods();
 //       System.out.println(Arrays.toString(methods));
        for (Method method : methods) {
            for (Annotation annotation : getMethodAnnotations(method)) {
                if (annotation != null) {
                    if (annotation instanceof Test) {
                        fixtureMethodRun(testClass,BeforeEach.class);
                        TestRun(method, testClass);
                        fixtureMethodRun(testClass,AfterEach.class);
                    } else if (annotation instanceof ParameterizedTest) {
                        if (method.isAnnotationPresent(ValueSource.class)) {
                            fixtureMethodRun(testClass,BeforeEach.class);
                            ParametrizedTestRun(method, testClass,method.getAnnotation(ValueSource.class));
                            fixtureMethodRun(testClass,AfterEach.class);
                        }
                    }
                }
            }
        }
        fixtureMethodRun(testClass, AfterAll.class);
        System.out.println("\n***");
    }

    private static void fixtureMethodRun(Class<?> testClass, Class<? extends Annotation> annotationClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Method method: testClass.getMethods()) {
            if (method.isAnnotationPresent(annotationClass)){
                method.invoke(testClass.getConstructor().newInstance());
            }
        }
    }

    public static void TestRun(Method method, Class<?> testClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        try {
            method.invoke(testClass.getConstructor().newInstance());
            testSuccessResult(testClass, method);
        } catch (Exception e) {
            testFailedResult(testClass, method);
        }

    }
    public static void ParametrizedTestRun(Method method, Class<?> testClass, Annotation sourceTypeAnnotation) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        if (sourceTypeAnnotation instanceof ValueSource){
            if (((ValueSource) sourceTypeAnnotation).strings().length != 0){
                String[] args = ((ValueSource) sourceTypeAnnotation).strings();

                for (String arg: args) {
                    try {
                        method.invoke(testClass.getConstructor().newInstance(), arg);
                        testSuccessResult(testClass, method);
                    } catch (Exception e) {
                        testFailedResult(testClass, method);
                    }
                }
            } else if (((ValueSource) sourceTypeAnnotation).ints().length != 0) {
                int[] args = ((ValueSource) sourceTypeAnnotation).ints();

                for (int arg: args) {
                    try {
                        method.invoke(testClass.getConstructor().newInstance(), arg);
                        testSuccessResult(testClass, method);
                    } catch (Exception e) {
                        testFailedResult(testClass, method);
                    }
                }
            }
        }
    }

    private static void testSuccessResult(Class<?> testClass, Method method) {
        System.out.println(format("SUCCESS | Test: %s passed in testClass: %s!", method.getName(), testClass.getName()));
    }

    private static void testFailedResult(Class<?> testClass, Method method) {
        System.out.println(format("FAILED | Test: %s failed in testClass: %s!", method.getName(), testClass.getName()));
    }

}
