package com.ex;

/**
 * Created by August Duet on 5/25/2017.
 */
public class Person {

    private String username;
    private String email;
    private int age;

    public Person() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void doWork(){
        System.out.println("Working");
    }

    public int ageMe(int years){
        return age + years;
    }
}
