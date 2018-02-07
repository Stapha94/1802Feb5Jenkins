package QNineteen;

import java.util.*;

public class IntegerArrayList {

    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<>();
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 1; i <= 10; i++){

            intList.add(i);

        }

        for (int i = 0; i < intList.size(); i++){

            System.out.println(intList.get(i));

        }

        for (int i = 0; i <= intList.size(); i++){

            if(i%2 == 0){

                evenSum = evenSum + i;

            }
            else
                oddSum = oddSum + i;

        }

        System.out.println("The sum of all evens is: " + evenSum);
        System.out.println("The sum of all odds is: " + oddSum);

        for (int i = intList.size() - 1; i >=0; i--){

            if(isPrime(intList.get(i))){

                intList.remove(i);

            }

        }

        for (int i = 0; i < intList.size(); i++){

            System.out.println(intList.get(i));

        }

    }

    public static boolean isPrime(int n) {

        for(int i = 2 ;i < n; i++) {

            if(n % i == 0)

                return false;

        }
        if(n == 2){

            return false;

        }
        return true;

    }

}
