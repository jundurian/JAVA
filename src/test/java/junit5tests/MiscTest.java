package junit5tests;

import org.junit.jupiter.api.*;

public class MiscTest {

    @Test
    @Timeout(5)
    void timeout() throws InterruptedException {
        System.out.println("Timeout test");
        Thread.sleep(6000);
    }

    @Test
    @Timeout(90)
    @DisplayName("This is the nice method")
    @Tag("theTag")
    void annotatedMethod(){
        System.out.println("Annotated Test");
    }

    @MyAnnotation
    void CustomAnnotation(){
        System.out.println("Custom annotation");
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTests {

        @BeforeAll
        void beforeAll(){
            System.out.println("Before All in nested test");
        }

        @Test
        void nestedTestMethod(){
            System.out.println("Nested Test");
        }
    }
}
