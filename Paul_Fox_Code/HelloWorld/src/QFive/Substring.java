package QFive;

import java.util.*;

public class Substring {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        String myString = "";
        int myInt;
        System.out.println("Enter a String to substring: ");
        myString = myScanner.nextLine();
        System.out.println("Enter a number to Substring it to");
        myInt = Integer.parseInt(myScanner.nextLine());

        char[] myArray = myString.toCharArray();
        String result = "";

        for(int i = 0; i < myInt; i++){

            result = result + myArray[i];

        }

        System.out.println(result);

    }

}
