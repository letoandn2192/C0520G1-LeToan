package array_and_method_in_array.thuc_hanh;

import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập Tên Bạn Muốn Kiểm Tra: ");
        String name = input.nextLine();
        boolean check = false;
        for (String student : students) {
            if (student.equals(name)) {
                check = true;
                break;
            }
        }
        if(check){
            System.out.println("Có sinh viên " + name + " trong lớp.");
        }else {
            System.out.println("Không có sinh viên " + name + " trong lớp.");
        }
    }
}
