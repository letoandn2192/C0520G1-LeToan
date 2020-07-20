package sort_algorithm.exercises;

public class Illustration_InsertSort {
    public static void main(String[] args) {
        int[] array = {2, 7, 9, 5};
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        insertSort(array);
        System.out.println();
//        InsertSort(array1);
    }

    public static void insertSort(int[] array) {
        System.out.println("Illustration_InsertSort");
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            System.out.print("Step " + i + ": ");
            for (; j >= 0 && temp < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
            for (int element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Array Sorted: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }

}
