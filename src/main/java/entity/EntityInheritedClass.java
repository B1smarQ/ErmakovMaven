package entity;

import annotations.ToString;

public class EntityInheritedClass extends Entity{
    @ToString
    private String stringField1;
    @ToString
    private Integer integerField2;
    @ToString
    private Double doubleField3;
    @ToString
    private boolean booleanField4;
    public EntityInheritedClass(String stringField1, Integer integerField2, Double doubleField3, boolean booleanField4) {
        this.stringField1 = stringField1;
        this.integerField2 = integerField2;
        this.doubleField3 = doubleField3;
        this.booleanField4 = booleanField4;
    }
}
