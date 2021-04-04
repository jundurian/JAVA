package junit5tests;

import junit5tests.listeners.Listener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@ExtendWith(Listener.class)
public class DisabledEnabledTests {

    @Test
    @Disabled(value = "Disabled for demo")
    void firstTest(){
        System.out.println("First Test");
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled on Windows")
    //@EnabledOnOs(value = OS.MAC)
    void secondTest(){
        System.out.println("Second Test");
    }

    @Test
    @DisabledIfSystemProperty(named = "env", matches = "staging", disabledReason = "Disable if " +
            "Env is Staging")
    void thirdTest(){
        System.out.println("Third Test");
    }

    @Test
    @DisabledIf(value = "provider", disabledReason = "Disable")
    void fourthTest(){
        System.out.println("Fourth Test");
    }

    @Test
    void fifthTest(){
        System.out.println("Fifth Test");
    }

    boolean provider() {
    return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SATURDAY);
    }
}
