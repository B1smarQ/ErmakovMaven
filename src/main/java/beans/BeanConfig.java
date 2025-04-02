package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;


@Configuration
public class BeanConfig {
    Set<Integer> numbers = new HashSet<>();
    List<Review> revs = new ArrayList<>();
    @Bean
    public String bean1(){
        return  "Hello World";

    }
    @Bean
    public Integer max(){
        return 100;
    }
    @Bean
    public Integer min(){ return 10; }
    @Bean
    @Scope("prototype")
    @Lazy
    public Integer bean2(@Qualifier("min") Integer min, @Qualifier("max") Integer max) {

        if(max < min){
            throw new IllegalArgumentException("Max must be bigger than min");
        }
        Integer num = new Random().nextInt(max-min-1)+min;
        while(numbers.contains(num) && numbers.size() < max-min-1){
            num = new Random().nextInt(max-min-1)+max;
        }
        numbers.add(num);
        return num;
    }
    @Bean
    public Review review1(){
        return new Review("good",5);
    }
    @Bean
    public Review review2(){
        return new Review("fine",4);
    }
    @Bean
    @Lazy
    public Review review3(@Qualifier("bean2") Integer num){
        return new Review("dunno",num);
    }
    @Bean
    @Lazy
    public Predicate<Integer> bean3(Integer num){
        return n->num>=2&&num<=5;
    }

    @Bean
    @Scope("singleton")
    @Lazy
    public Date bean4(){
        return new Date();
    }

}

@Component
class TrafficLight{
    @Autowired @Qualifier("green")
    ColorState state;
}

interface ColorState{
    ColorState next();
}
@Component
class RedLight implements ColorState{
    @Autowired @Qualifier("green") ColorState nextColor;
    @Override
    public ColorState next() {
        return nextColor;
    }
}
@Component
class GreenLight implements ColorState{
    @Autowired @Qualifier("red") ColorState nextColor;
    @Override
    public ColorState next() {
        return nextColor;
    }
}

