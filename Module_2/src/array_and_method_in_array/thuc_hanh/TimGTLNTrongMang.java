package array_and_method_in_array.thuc_hanh;

import java.util.Scanner;

public class TimGTLNTrongMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chiều dài mảng: ");
        int size = input.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            array[i] = (int)(Math.floor(Math.random() * 100));
        }
        System.out.print("Mảng đã tạo: ");
        for(int element : array){
            System.out.print(element + " ");
        }
        int max = array[0];
        for (int element: array){
            if(element > max){
                max = element;
            }
        }
        System.out.println("");
        System.out.print("GTLN của mảng là: "+ max);
    }
}
