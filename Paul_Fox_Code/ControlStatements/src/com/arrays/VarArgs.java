package com.arrays;

public class VarArgs {

    public static void main(String[] args) {

        printArray(new Object[]{1,2,3,4});
        printVarArgs( 1,2,3,4,5);

    }

    public static void printArray(Object[] args){



    }

    public static void printVarArgs(int... ints){

        for (int i: ints){

            System.out.println(i);

        }

    }

}
