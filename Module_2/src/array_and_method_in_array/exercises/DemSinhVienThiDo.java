package array_and_method_in_array.exercises;

import java.util.Scanner;

public class DemSinhVienThiDo {
    public static void main(String[] args) {
        int size;
        int count = 0;
        int checkPass = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Nhập số sinh viên: ");
            size = input.nextInt();
        }while(size <1 || size >30);

        int[] array = new int[size];
        while (count < size){
            System.out.print("Nhập điểm của sinh viên thứ " + (count+1) + " : ");
            array[count] = input.nextInt();
            while (array[count] < 0 || array[count] > 10){
                System.out.print("Nhập lại điểm của sinh viên thứ " + (count+1) + " : ");
                array[count] = input.nextInt();
            }
            count++;
        }
        System.out.println("Danh sách điểm sinh viên:");
        for(int value: array){
            System.out.print(value + "\t");
            if(value >= 5){
                checkPass++;
            }
        }

        System.out.println();
        System.out.print("Số lượng sinh viên đỗ: " + checkPass);
    }
}
