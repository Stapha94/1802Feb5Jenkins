package QEight;

import java.util.*;

public class Palindromes {

    public static ArrayList<String> palindromesList = new ArrayList();
    public static ArrayList<String> initialList = new ArrayList();

    public static void main(String[] args) {

        initialList.add("karan");
        initialList.add("madam");
        initialList.add("tom");
        initialList.add("civic");
        initialList.add("radar");
        initialList.add("sexes");
        initialList.add("jimmy");
        initialList.add("kayak");
        initialList.add("john");
        initialList.add("refer");
        initialList.add("billy");
        initialList.add("did");

        checkPalindrome(initialList);

        for (int i = 0; i < palindromesList.size(); i++){

            System.out.println(palindromesList.get(i));

        }
        System.out.println();

        for (int i = 0; i < initialList.size(); i++){

            System.out.println(initialList.get(i));

        }

    }

    public static void checkPalindrome(ArrayList<String> initialList){


        int x1 = 0;
        int x2 = initialList.size()-1;

        for (int i = 0; i < initialList.size(); i++){

            String normalString = initialList.get(i);
            String reverseString = initialList.get(i);
            StringBuilder myRBuilder = new StringBuilder();
            myRBuilder.append(reverseString);
            reverseString = myRBuilder.reverse().toString();

            if (normalString.equalsIgnoreCase(reverseString)){

                palindromesList.add(initialList.get(i));

            }

        }

    }

}
