package beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeansTests {

    @Test
    @DisplayName("Random bean's max < min")
    void randomBeanTest(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext("beans");
        int min = (int)ctx.getBean("min",100);
        int max = (int)ctx.getBean("max",10);
        try{
            int num = (int)ctx.getBean("bean2");
        }
        catch (BeanCreationException _){
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
