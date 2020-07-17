package search_algorithm.exercises.binary_search_recursion;

public class Binary_Search {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(array, 10, array.length-1, 0));
    }

    public static int binarySearch(int[] array, int value, int high, int low){

        int mid = (high + low)/2;
        if(high >= low){
            if(array[mid] == value){
                return mid;
            }else if(array[mid] < value){
                return binarySearch(array, value, high, mid + 1);
            }else {
                return binarySearch(array, value, mid-1, low);
            }
        }
        return -1;
    }
}
