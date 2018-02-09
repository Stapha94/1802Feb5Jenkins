package com.exceptions;

public class Exceptions {

    public static void main(String[] args) {

//        try {
//            Class.forName(Object.class.getName());
//            System.out.println("Hi");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println("This runs no matter what, ALMOST");
//        }
//
//        System.out.println("Hi again!");



        try {
            System.out.println(div(100, 10));
            System.out.println(div(10, 0));
        } catch(BadMathException e) {
            e.printStackTrace();
        }

        System.out.println("Hi");

    }

    public static int div(int x, int y) throws BadMathException{
        if(y == 0) {
            throw new BadMathException("Check your input");
        }
        return x / y;
    }

}

class BadMathException extends Exception {
    public BadMathException(String msg) {
        super(msg);
    }
}
