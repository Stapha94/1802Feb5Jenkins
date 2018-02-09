package com.loops;

public class WhileLoop {

    public static void main(String[] args) {
        int x = 0;

        //do{}while();

        while(true) {

            x++;

            if(x%2 == 0){
                continue;
            }

            System.out.println("x is " + x);

            if(x >= 10) {
                break;
            }
        }
    }
}
