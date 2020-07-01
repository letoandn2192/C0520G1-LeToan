package array_and_method_in_array.bai_tap;

import java.util.Scanner;

public class ThemPhanTuTrongMang {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,0,0,0,0,0};
        boolean check;
        int index;
        int value;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("Nhập vị trí bạn muốn thêm phần tử: ");
            index = input.nextInt();
            if(index >= array.length || index < 0){
                check = false;
                System.out.println("Giá trị không hợp lệ.");
            }else {
                check = true;
            }
        }while (!check);
        System.out.println("Nhập giá trị của phần tử: ");
        value = input.nextInt();
        for (int i = array.length - 1; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = value;
        System.out.print("Mảng sau khi thêm: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
