package array_and_method_in_array.bai_tap;

import java.util.Scanner;

public class XoaPhanTuTrongMang {
    public static void main(String[] args) {
        int[] array = {1,2,3,5,5,6,7,0,0};
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập phần tử cần xóa: ");
        int delElement = input.nextInt();
        for(int i = 0; i < array.length; i++){
            if(delElement == array[i]){
                for(;i < array.length-1; i++){
                    array[i] = array[i+1];
                }
            }
        }
        array[array.length-1] = 0;
        System.out.print("Mảng sau khi xóa: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
