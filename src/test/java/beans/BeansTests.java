package beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeansTests {

    @Test
    @DisplayName("Random bean's max < min")
    void randomBeanTest(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext("beans");
        try{
            int num = (int)ctx.getBean("bean2");
        }
        catch (BeanCreationException e){
            Throwable tb = e.getCause();
            if(tb instanceof BeanInstantiationException tf){
                if(tf.getCause() instanceof IllegalArgumentException tt){
                }
                else{
                    throw new RuntimeException(tf);
                }
            }
            else{
                throw new RuntimeException(tb);
            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        throw new AssertionFailedError();

    }
}
