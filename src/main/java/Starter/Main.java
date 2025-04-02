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
        System.out.println(context.getBean("bean2"));
        System.out.println(context.getBean("bean2"));

        Review rev1 = (Review) context.getBean("review1");
        Review rev2 = (Review) context.getBean("review2");
        Review rev3 = (Review) context.getBean("review3");

        System.out.println(rev1);
        System.out.println(rev2);
        System.out.println(rev3);

    }
}