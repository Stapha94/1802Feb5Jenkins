package com.arrays;

public class PrimitiveArrays {
    public static void main(String[] args) {
        //int x = 10
        //String s = "Cat";

        //System.out.println(args[0]);

        int[] iArr = new int[5];
        String[] sArr = new String[5];

//        iArr[0] = 1;
//        iArr[1] = 2;
//        iArr[2] = 3;
//        iArr[3] = 4;
//        iArr[4] = 5;

//        for(int i = 0; i < iArr.length; i++) {
//            System.out.println("iArr[" + i+ "] is " + iArr[i]);
//        }
//
//        for(int i = 0; i < sArr.length; i++) {
//            System.out.println("sArr[" + i+ "] is " + sArr[i]);
//        }

        //multi-dimensional
        int[][] mdIArr = new int[2][];
        mdIArr[0] = new int[]{1, 2, 3, 4};
        mdIArr[1] = new int[]{1,2,3,4,5};

        //mdIArr[0]; returns an array
        //mdIArr[0][0]; returns an int

        for(int i = 0; i < mdIArr.length; i++) {
          for(int j = 0; j < mdIArr[i].length; j++) {
              System.out.println(mdIArr[i][j]);
          }
        }

        //all are md arrays
        int[][] a1;
        int[] a2[];
        int a3[][];

    }
}
