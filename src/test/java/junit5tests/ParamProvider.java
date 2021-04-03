package junit5tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvider {

    static List<Arguments> sourceList_StringDouble(){
        return Arrays.asList(arguments("tomate", 2.0), arguments("banana", 2.4));
    }
}
