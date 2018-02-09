package com.ex;

public class B extends A {

    public B() {
        super();
        System.out.println("Construct B");
    }

    public void m1() {
        System.out.println("B -- m1");
    }

    public void m2() {
        System.out.println("B -- m2");
    }
}
