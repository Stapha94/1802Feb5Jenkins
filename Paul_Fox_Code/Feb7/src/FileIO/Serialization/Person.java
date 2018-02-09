package FileIO.Serialization;

import java.io.Serializable;

public class Person implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    transient private String SSN;

    public Person(){



    }

    public String getName() {

        return name;

    }

    public int getAge() {

        return age;

    }

    public String getSSN() {

        return SSN;

    }

    public void setName(String name) {

        this.name = name;

    }

    public void setAge(int age) {

        this.age = age;

    }

    public void setSSN(String SSN) {

        this.SSN = SSN;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", SSN='" + SSN + '\'' +
                '}';
    }
}
