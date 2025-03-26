package beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.*;
import java.util.function.Predicate;


@Configuration
public class BeanConfig {
    Set<Integer> numbers = new HashSet<>();
    @Bean
    public String bean1(){
        System.out.println("Hello World!");
        return  "Hello World";

    }
    @Bean
    @Lazy
    public Integer max(Integer num){
        return num;
    }
    @Bean
    @Lazy
    public Integer min(Integer num){
        return num;
    }
    @Bean
    @Scope("prototype")
    @Lazy
    public Integer bean2(@Qualifier("min") Integer min, @Qualifier("max") Integer max) {
        if(max < min){
            throw new IllegalArgumentException("Max must be bigger than min");
        }
        Integer num = new Random().nextInt(max-min-1)+min;
        while(numbers.contains(num) && numbers.size() <=max-min-1){
            num = new Random().nextInt(max-min-1)+max;
        }
        numbers.add(num);
        return num;
    }

    @Bean
    @Lazy
    public Predicate<Integer> bean3(Integer num){
        return n->num>=2&&num<=5;
    }

    @Bean
    @Scope("singleton")
    public Date bean4(){
        return new Date();
    }

}

