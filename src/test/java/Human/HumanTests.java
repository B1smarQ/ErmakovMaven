package Human;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HumanTests {
    @Test
    @DisplayName("Negative age test")
    void test1(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Human(-10, "John", (byte)1));
    }
    @Test
    @DisplayName("Age >100 test")
    void test2(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Human(101, "John", (byte)1));
    }
    @Test
    @DisplayName("Invalid gender test")
    void test3(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Human(10, "Johnny", (byte)2));
    }
    @Test
    @DisplayName("Empty name test")
    void test4(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Human(10, "", (byte)1));
    }
}
