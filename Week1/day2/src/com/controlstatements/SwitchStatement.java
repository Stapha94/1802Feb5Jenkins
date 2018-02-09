package com.controlstatements;

public class SwitchStatement {
    public static void main(String[] args) {
        int x = 10;

        switch (x) {
            case 5: {
                System.out.println("x is 5");
            }

            case 10: {
                System.out.println("x is 10");
            }

            case 15: {
                System.out.println("x is 15");
            }

            default: {
                System.out.println("x is " + x);
                break;
            }
        }
    }
}
