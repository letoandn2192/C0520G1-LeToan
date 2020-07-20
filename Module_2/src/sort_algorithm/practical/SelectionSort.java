package sort_algorithm.practical;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        double[] array1 = {1, 9, 4.5, 6.6, 5.7, -4.5};
        selectSort(array);
        selectSort(array1);
        System.out.println();
        for (int element: array){
            System.out.print(element + " ");
        }
    }
    public static void selectSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
            System.out.println();
            for (int element: array){
                System.out.print(element + " ");
            }
        }
    }

    public static void selectSort(double[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    double temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
}
