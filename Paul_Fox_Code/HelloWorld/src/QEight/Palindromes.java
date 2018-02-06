package QEight;

import java.util.*;

public class Palindromes {

    public static void main(String[] args) {

        Palindromes myPalindromes = new Palindromes();
        ArrayList<String> initialList = new ArrayList();
        ArrayList<String> palindromesList = new ArrayList();
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

        myPalindromes.checkPalindrome(myList);

    }

    public void checkPalindrome(ArrayList<String> initialList){

        int x1 = 0;
        int x2 = initialList.size()-1;

        for (int i = 0; i < initialList.size(); i++){

            while (x1 < x2){

                if (initialList.get(i).charAt(x1) != initialList.get(i).charAt(x2)){

                    break;

                }
                else{

                    if (x1 == x2){

                        

                    }

                }

            }

        }

    }

}
