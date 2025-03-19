package utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FindFields {
    public static List<Field> findFields(Class<?> cl){
        List<Field> fields = new ArrayList<>(List.of(cl.getDeclaredFields()));
        if(cl.equals(Object.class)){
            return List.of();
        }
        fields.addAll(findFields(cl.getSuperclass()));
        return fields;
    }
}
