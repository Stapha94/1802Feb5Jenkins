package QTwelve;

public class EForLoopEvenNumbers {

    public static void main(String[] args) {

        int[] myIntArray = new int[101];

        for(int i = 1; i <=100; i++){

            myIntArray[i] = i;
            //System.out.println(myIntArray[i]);

        }

        for(Integer i: myIntArray){

            if(i%2 == 0){

                System.out.println(i);

            }

        }

    }

}
