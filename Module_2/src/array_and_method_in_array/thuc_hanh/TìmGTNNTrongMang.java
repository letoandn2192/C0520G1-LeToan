package array_and_method_in_array.thuc_hanh;

public class TìmGTNNTrongMang {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int index = findMin(array);
        System.out.println("GTNN của mảng là :"+array[index]);
    }
    ///////////////////////////////////
    public static int findMin(int[] array){
        int index = 0;
        int min = array[0];
        for(int i = 0; i < array.length; i++){
            if(min > array[i]){
                min = array[i];
                index = i;
            }
        }
        return index;
    }
}
