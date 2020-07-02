package array_and_method_in_array.exercises;

import java.util.Scanner;

public class DemSoLanXuatHienKiTu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        System.out.println("Nhập chuỗi bạn muốn kiểm tra: ");
        String checkString = input.nextLine();
        System.out.println("Nhập kí tự bạn muốn kiểm tra: ");
        char character = input.next().charAt(0);
        for(int i = 0; i < checkString.length(); i++){
            if(character == checkString.charAt(i)){
               count++;
            }
        }
        System.out.println("Sô lần xuất hiện của kí tự "+ character + " là: " + count);
    }
}
