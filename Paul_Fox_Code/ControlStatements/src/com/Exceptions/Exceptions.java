package com.Exceptions;

import java.rmi.server.ExportException;

public class Exceptions {

    public static void main(String[] args) {

        try {

            Class.forName(Object.class.getName());
            System.out.println("Hi");

        }
        catch (ClassNotFoundException e){

            e.printStackTrace();

        }
        finally {

            System.out.println("This runs no matter what, ALMOST");

        }

        System.out.println("hi again");

    }

    public static int div(int x, int y) throws BadMathException {

        if(y == 0){

            throw new BadMathException("Check your input");

        }
        return x / y;

    }

}

class BadMathException extends Exception{

    public BadMathException(String msg){

        super(msg);

    }

}