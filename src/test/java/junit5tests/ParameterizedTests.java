package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppingList.csv", numLinesToSkip = 1)
    void csvFileSource(String name, double price, int qty, String
                       unity, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", unity = " + unity + ", provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppingList.csv","src/test/resources/params/shoppingList2.csv"},
            numLinesToSkip = 1)
    void csvFileSourc2(String name, double price, int qty, String
            unity, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", unity = " + unity + ", provider = " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1){
        System.out.println("param1 = " + param1);

    }

    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceList_StringDouble")
    void methodSource_StringDouble(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);

    }


    List<String> sourceString() {
        return Arrays.asList("tomate", "cenoura","banana");
    }



}
