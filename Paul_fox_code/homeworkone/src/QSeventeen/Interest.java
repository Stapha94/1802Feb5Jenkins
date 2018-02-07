package QSeventeen;

import java.util.*;

public class Interest {

    public static void main(String[] args) {

        int principal;
        int rate;
        int years;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the Principal: ");
        principal = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter the Rate: ");
        rate = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter the time: ");
        years = Integer.parseInt(myScanner.nextLine());

        System.out.println("The interest is: " + principal*rate*years);



    }

}
