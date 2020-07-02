package array_and_method_in_array.practical;

public class DaoNguocPhanTuMang {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.printf("%-23s%s","Mảng sau khi đổi là:","");
        for (int value : array) {
            System.out.print(value + " ");
        }
        for(int i = 0; i <= array.length/2; i++){
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println("");
        System.out.printf("%-23s%s","Mảng sau khi đổi là:","");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
