package com.ex;

public class Main {

    private String msg;

    public Main(){}

    public Main(String msg){

        this.msg = msg;

    }

    public static void main(String[] args){

        //System.out.println("Hello, World");
        Main m = new Main();
        m.sayHello();


        A a = new A();

        System.out.println("_____________________________");

        A b = new B();

        b.m1();
    }



    public void sayHello(){

        if(this.msg != null){

            System.out.println(this.msg);

        }
        else{

            System.out.println("Hello, World");

        }

    }
}
