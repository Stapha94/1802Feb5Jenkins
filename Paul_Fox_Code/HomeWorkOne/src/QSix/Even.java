package QSix;

import java.util.*;

public class Even {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int isItEven;
        System.out.println("Enter a number to determine whether or not it is Even");
        isItEven = Integer.parseInt(myScanner.nextLine());

        if ((isItEven & 1 )== 0){

            System.out.println("It is Even");

        }
        else
            System.out.println("It is Odd");

    }


}
