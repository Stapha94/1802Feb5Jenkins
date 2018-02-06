package com.controlstatements;

public class SwitchStatements {

    public static void main(String[] args) {

        int x = 10;

        switch (x) {

            case 5: {

                System.out.println("X is 5");
                break;

            }

            case 10: {

                System.out.println("X is 10");
                break;

            }

            case 15: {

                System.out.println("X is 15");
                break;

            }

            default: {

                System.out.println("X is " + x);
                break;

            }

        }

    }

}
