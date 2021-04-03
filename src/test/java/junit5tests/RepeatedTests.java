package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class RepeatedTests {

    @RepeatedTest(5)
    void firstRepeatedTest(){
        System.out.println("Teste repetido");
    }

    @RepeatedTest(value = 3,name = "Running repetition: {currentRepetition}. Total" +
            " is: {totalRepetitions}")
    @DisplayName("Teste repetido")
    void secondRepeatedTest(){
        System.out.println("Outro teste repetido");
    }

    @RepeatedTest(4)
    void thirdRepeatedTest(RepetitionInfo repetitionInfo){
        System.out.println("Codigo roda toda vez");
        assumingThat(repetitionInfo.getCurrentRepetition() == 3,
                () -> System.out.println("rodando só na terceira repetição"));
    }
}
