package QTen;

import java.util.*;

public class Min {

    static Scanner inputScanner = new Scanner(System.in);
    private static String sNumber;
    private static int number;
    private static int secondNumber;

    public static void main(String[] args) {

        System.out.println("Enter a number to determine the minimum: ");
        sNumber = inputScanner.nextLine();
        number = Integer.parseInt(sNumber);
        System.out.println("Enter a second number to determine the minimum: ");
        sNumber = inputScanner.nextLine();
        secondNumber = Integer.parseInt(sNumber);

        if(number > secondNumber){

            System.out.println("The minimum of the two numbers is " + secondNumber);

        }
        else if (secondNumber > number){

            System.out.println("The minimum of the two numbers is " + number);

        }

    }

}
