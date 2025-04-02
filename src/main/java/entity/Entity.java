package entity;

import annotations.ToString;
import annotations.ToStringValues;

import java.lang.reflect.Field;
import java.util.stream.Collectors;

import static utils.FindFields.findFields;

public abstract class Entity {
    private String  findFieldValues(Field field) {
        if(field.isAnnotationPresent(ToString.class) && field.getAnnotation(ToString.class).value() == ToStringValues.NO)
            return "";
        if(getClass().isAnnotationPresent(ToString.class) ||( field.isAnnotationPresent(ToString.class)
                && field.getAnnotation(ToString.class).value() == ToStringValues.YES)) {
            field.setAccessible(true);
            try {
                return field.getName() + " = " + field.get(this);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
        return "";
    }
    public String toString() {
        return getClass().getSimpleName() + " {"+ findFields(getClass())
                .stream()
                .map(this::findFieldValues)
                .collect(Collectors.joining(", ")) + "}";
    }
}
