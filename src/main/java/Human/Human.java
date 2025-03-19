package Human;


import annotations.Default;
import lombok.Delegate;

@Default(Human.class)
public class Human {

    private  int age = 5;

    private  String name ;
    private  byte gender = 1;

    public Human(int age, String name, byte gender) {
        if(age<0)
            throw new IllegalArgumentException("Age should be non-negative");
        if(age>100)
            throw new IllegalArgumentException("Age should not be greater than 100");
        if(name==null || name.isEmpty())
            throw new IllegalArgumentException("Name should not be null or empty");
        if(gender!=0 && gender!=1)
            throw new IllegalArgumentException("Gender should be either 0 for Male or 1 for Female");
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public Human() {
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public byte getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
