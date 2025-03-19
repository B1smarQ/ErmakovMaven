package annotations;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnnotationProcessors{
    public static String collect(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Method[] methods = clazz.getMethods();
        Map<String, Object> output = new HashMap<>();
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object obj = constructor.newInstance();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                Object result = method.invoke(obj);
                output.put(method.getName(), result);
            }
        }
        return output.toString();
    }

    public static void reset(Object... objects) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        if (objects == null) return;
        
        for (Object obj : objects) {
            if (obj == null) continue;
            
            Class<?> clazz = obj.getClass();
            boolean resetAllFields = clazz.isAnnotationPresent(Default.class);
            
            for (Field field : clazz.getDeclaredFields()) {
                if (resetAllFields || field.isAnnotationPresent(Default.class)) {
                    field.setAccessible(true);
                    
                    if (field.isAnnotationPresent(Default.class)) {
                        Object defaultValue = getDefaultValue(field, clazz);

                        field.set(obj, defaultValue);
                    } else {
                        Class<?> fieldType = field.getType();
                        if (fieldType == boolean.class || fieldType == Boolean.class) {
                            field.set(obj, false);
                        } else if (fieldType == byte.class || fieldType == Byte.class) {
                            field.set(obj, (byte) 0);
                        } else if (fieldType == short.class || fieldType == Short.class) {
                            field.set(obj, (short) 0);
                        } else if (fieldType == int.class || fieldType == Integer.class) {
                            field.set(obj, 0);
                        } else if (fieldType == long.class || fieldType == Long.class) {
                            field.set(obj, 0L);
                        } else if (fieldType == float.class || fieldType == Float.class) {
                            field.set(obj, 0.0f);
                        } else if (fieldType == double.class || fieldType == Double.class) {
                            field.set(obj, 0.0d);
                        } else if (fieldType == char.class || fieldType == Character.class) {
                            field.set(obj, '\u0000');
                        } else {
                            field.set(obj, null);
                        }
                    }
                }
            }
        }
    }

    private static @NotNull Object getDefaultValue(Field field, Class<?> clazz) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> defaultValueClass = field.getAnnotation(Default.class).value();
        if(defaultValueClass != clazz){
            throw new IllegalStateException();
        }

        Constructor<?> constructor = defaultValueClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }
}
