package QOne;

public class BubbleSort {

    public static void main(String[] args) {

        BubbleSort mySort = new BubbleSort();
        int[] myArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
        mySort.bubbleSort(myArray);
        mySort.printArray(myArray);

    }

    public void bubbleSort(int[] array){

        int x = array.length;

        for (int i = 0; i < x - 1; i++){
            for (int j = 0; j < x - i - 1; j++){
                if (array[j] > array[j+1]){

                    int temp = array[j+1];
                    int temp2 = array[j];
                    array[j] = temp;
                    array[j+1] = temp2;

                }
            }
        }

    }

    public void printArray(int[] array){

        int x = array.length;
        for (int i = 0; i < x; i++){
            System.out.println(array[i] + "");
        }

    }

}
