package Starter;
import beans.BeanConfig;
import beans.Review;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("beans", "Starter");
        String str = (String) context.getBean("bean1");
        System.out.println(str);
        Integer min = (Integer) context.getBean("min",10);
        Integer max = (Integer) context.getBean("max",100);
        System.out.println(context.getBean("bean2"));
        System.out.println(context.getBean("bean2"));

        Review rev1 = new Review("good",5);
        Review rev2 = new Review("meh",3);
        Review rev3 = new Review("dunno",(int)context.getBean("bean2"));

        System.out.println(rev1);
        System.out.println(rev2);
        System.out.println(rev3);

    }
}