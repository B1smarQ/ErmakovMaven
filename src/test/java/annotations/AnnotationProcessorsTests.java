package annotations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.InvokableClass;
import java.lang.reflect.InvocationTargetException;

public class AnnotationProcessorsTests {
    @Test
    @DisplayName("Collect test")
    void collectTest() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String testString = AnnotationProcessors.collect(InvokableClass.class);
        Assertions.assertTrue(testString.contains("invoke1=42")
                && testString.contains("invoke2=Hello, World")
                && testString.contains("invoke3=3.14"));
    }

    @Test
    @DisplayName("Null invocation test")
    void nullTest(){
        try{
            AnnotationProcessors.collect(null);
        } catch (NullPointerException _){
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
