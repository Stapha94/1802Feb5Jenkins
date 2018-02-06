package QFour;
import java.util.*;

public class NFactorial {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number to compute the Factorial of: ");
        int choice = Integer.parseInt(myScanner.nextLine());
        int factorial = 1;

        for(int i = 1; i <= choice; i++){

            factorial = factorial*i;
            System.out.println(factorial);

        }

    }

}
