package junit5tests;

import com.sun.xml.internal.ws.message.stream.StreamHeader11;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index} - value: {arguments} ")
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam){
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"firstString", "secondString"})
    void stringValues(String theParam){
        System.out.println("theParam = " + theParam);
    }


    @ParameterizedTest
    @CsvSource(value = {"steve, rogers", "clark, kent", "bruce, wayne"})
    void csvSource_StringString(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve, 3, true", "clark, 99, false"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"capitao america, 'steve, rogers'", "homem de ferro, 'tony, stark'"})
    void csvSource_StringWithComa(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Steve?Rogers", "Clark?Kent"}, delimiter = '?')
    void csvSource_StringWithDifferentDelimiter(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }


}
