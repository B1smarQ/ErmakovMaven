package Starter;

import Human.Human;
import annotations.AnnotationProcessors;

import java.lang.reflect.InvocationTargetException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Human human = new Human(15,"john",(byte)1);
        System.out.println(human);
        AnnotationProcessors.reset(human);
        System.out.println(human);
        }
    }
