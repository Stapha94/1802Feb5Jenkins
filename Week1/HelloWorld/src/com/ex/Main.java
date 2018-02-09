package com.ex;

public class Main {

    private String msg;

    public Main() {}

    public Main(String msg) {
        this.msg = msg;
    }

    public static void main(String[] args) {
        //System.out.println("Hello, World!");
//        Main m = new Main();
//        m.sayHello();

        try {
            Class.forName(A.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }









    public void sayHello() {
        if(this.msg != null) {
            System.out.println(this.msg);
        } else {
            System.out.println("Hello, World!");
        }

        Object o;
    }
}
