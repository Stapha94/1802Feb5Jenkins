package com.controlstatements;

public class WhileLoop {

    public static void main(String[] args) {

        int x = 0;

        while (true){


            if (x%2 == 0){
                x++;
                continue;
            }

            x++;

            System.out.println("X is " + x);

            if (x >= 10){

                break;

            }

        }

    }

}
