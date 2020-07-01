package array_and_method_in_array.bai_tap;

import java.util.Scanner;

public class TinhTongCuaMotCot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số dòng của mảng: ");
        int row = input.nextInt();
        System.out.println("Nhập số cột của mảng: ");
        int col = input.nextInt();
        double[][] array = new double[5][5];
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                array[i][j] = Math.random() * 100;
            }
        }
        System.out.println("Mảng khởi tạo: ");
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                System.out.printf("%-8.2f", array[i][j]);
            }
            System.out.println();
        }
        ////////////////////////////////////////////////////
        double sum = 0;
        int sumCol;
        do {
            System.out.println("Nhập cột bạn muốn tính tổng: ");
            sumCol = input.nextInt();
        }while (sumCol < 0 || sumCol >= array.length);

        for(int i = 0 ; i < array.length; i++){
            sum += array[i][sumCol];
        }
        System.out.printf("Tổng của cột %d là: %.2f", sumCol, sum);
    }
}
