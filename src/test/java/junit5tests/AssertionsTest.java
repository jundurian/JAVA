package junit5tests;

import junit5tests.listeners.Listener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(Listener.class)
public class AssertionsTest {

    @Test
    void assertEquals(){
        Assertions.assertEquals("firstString",
                "secondString",
                "The string values" +
                        " were not equals");


    }

    @Test
    void assertEqualsList(){
        List<String> expectedValues = Arrays.asList("firstString", "secondString");
        List<String> actualValues = Arrays.asList("firstString", "secondString");

        Assertions.assertEquals(expectedValues,actualValues);

    }

    @Test
    void assertArraysEquals(){
        int[] expectedValues = {1,2,3};
        int[] actualValues = {1,2,3};

        assertArrayEquals(expectedValues,actualValues);

    }

    @Test
    void assertTrue(){
        Assertions.assertTrue(false, "Boolean not true");
    }

    @Test
    void assertThrowsTest(){

        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest(){
        assertAll(
                () -> Assertions.assertEquals(2,3),
                () -> assertThrows(NullPointerException.class, null),
                () -> Assertions.assertTrue(false, "Boolean not true")
        );
    }

    @Test
    void assertForMapTest(){

        Map<String,Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("SecondKey",2);
        theMap.put("ThirdKey",3);

        assertThat(theMap, hasValue(2));
        assertThat(theMap, hasKey("SecondKey"));
    }

    @Test
    void assertForListTest(){
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        assertThat(theList, hasItem("test"));
    }


    @Test
    void assertForAnyOfTest(){
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        assertThat(theList, anyOf(hasItem("thirdString"),
                hasItem("noString")));

        //assertThat(theList,Matchers.allOf(Matchers.hasItem("thirdString"),
          //      Matchers.hasItem("noString")));
    }


    @Test
    void assertForContainsInAnyOrderTest(){
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");

        assertThat(theList, containsInAnyOrder("firstString", "thirdString"
                ,"secondString"));
    }

}
