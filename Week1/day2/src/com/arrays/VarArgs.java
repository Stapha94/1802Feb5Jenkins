package com.arrays;

public class VarArgs {

    public static void main(String[] args) {

        printArray(new Object[]{1,2,3,4});
        printVarArgs("John", 1,2,3,4,5,6);

    }

    public static void printArray(Object[] args) {
        System.out.println();
    }

    public static void printVarArgs(String name, int... ints){

        for(int i : ints) {
            System.out.println(i);
        }

    }
}
