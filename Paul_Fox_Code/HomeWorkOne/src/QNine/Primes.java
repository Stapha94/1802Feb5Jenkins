package QNine;

import java.util.*;

public class Primes {

    public static ArrayList<Integer> numberList = new ArrayList();

    public static void main(String[] args) {

        for (int i = 0; i <= 100; i++){

            numberList.add(i);

        }

        for (int i = 0; i <= 100; i++) {

            if (isPrime(numberList.get(i))){

                System.out.println(numberList.get(i));

            }
        }

    }

    public static boolean isPrime(int n) {

        for(int i=2;i<n;i++) {

            if(n%i==0)

                return false;

        }
        return true;

    }



}
