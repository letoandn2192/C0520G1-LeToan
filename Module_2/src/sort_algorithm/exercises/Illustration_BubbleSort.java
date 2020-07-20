package sort_algorithm.exercises;

public class Illustration_BubbleSort {
    public static void main(String[] args) {
        int[] array = {7, 9, 3, 10, 6, 1, 17, 20, 8, 0};
        int[] array1 = {0,1,2,3,4,5,6,7,8,9,10};
        sortBubble(array);
        System.out.println();
        System.out.println("------------------------------------------");
        sortBubble(array1);
    }

    public static void sortBubble(int[] array) {
        boolean isCheck = true;
        int count = 0;
        int k = 1;
        while (isCheck) {
            isCheck = false;
            for (int i = 0; i < array.length - k; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    System.out.println(array[i] + " swap " + array[i+1]);
                    isCheck = true;
                }
            }
            k++;
            count++;
            System.out.print("Step " + count + ": ");
            for(int element: array){
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.print("Result: ");
        for(int element: array){
            System.out.print(element + " ");
        }
    }
}
