package com.arrays;

public class PrimitiveArrays {

    public static void main(String[] args) {

        int[] iArr = new int[5];
        String[] sArr = new String[5];

        iArr[0] = 1;
        iArr[1] = 2;
        iArr[2] = 3;
        iArr[3] = 4;
        iArr[4] = 5;

//        for (int i = 0; i < iArr.length; i++){
//
//            System.out.println("iArr{" + i + "] is " + iArr[i]);
//
//        }
//
//        for (int i = 0; i < sArr.length; i++){
//
//            System.out.println("sArr{" + i + "] is " + sArr[i]);
//
//        }

        int[][] mulArr = new int[2][5];
        mulArr[0] = new int[]{1,2,3,4};
        mulArr[1] = new int[]{1,2,3,4,5};

        for (int i = 0; i < mulArr.length; i++){

            for (int j = 0; j < mulArr[i].length; j++){

                System.out.println(mulArr[i][j]);

            }

        }

    }

}
