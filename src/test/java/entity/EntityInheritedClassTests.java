package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityInheritedClassTests {
    @Test
    void test1(){
        EntityInheritedClass t = new EntityInheritedClass("hello", 2, 3.3, false);
        System.out.println(t);
        Assertions.assertDoesNotThrow(t::toString);
    }
}
