package com.fileio;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    transient private String ssn;

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
