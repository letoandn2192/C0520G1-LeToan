package search_algorithm.practical.binary_search;

public class Binary_Search {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(array, 10));
    }

    public static int binarySearch(int[] array, int value){
        int low = 0;
        int high = array.length - 1;
        while (high >= low){
            int mid = (high + low)/2;
            if(array[mid] == value){
                return mid;
            }else if(array[mid] < value){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
