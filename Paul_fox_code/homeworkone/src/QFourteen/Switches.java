package QFourteen;

import java.time.LocalDateTime;
import java.util.*;

public class Switches {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        boolean done = false;

        while(!done){

            System.out.println("Choose an option: \n1. Find a Square Root of a Number\n2. Display Today's Date\n3. Split a String and Store it in an Array\n4. Quit");
            int choice = Integer.parseInt(myScanner.nextLine());

            switch (choice){

                case 1: {

                    System.out.println("Enter a number to get the square root of: ");
                    int number = Integer.parseInt(myScanner.nextLine());
                    System.out.println("Square Root of: " + number + " is: " + Math.sqrt(number));

                    break;
                }

                case 2: {

                    System.out.println(LocalDateTime.now());
                    break;
                }

                case 3: {

                    String s = "I am learning Core Java";
                    String[] sArray = new String[5];
                    sArray = s.split("\\s+");

                    for (int i = 0; i < sArray.length; i++){

                        System.out.println(sArray[i]);

                    }

                    break;
                }

                case 4: {

                    done = true;

                    break;
                }

            }

        }

    }

}
