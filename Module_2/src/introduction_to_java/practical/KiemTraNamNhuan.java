package introduction_to_java.practical;

import java.util.Scanner;

public class KiemTraNamNhuan {
    public static void main(String[] args) {
        short year;
        boolean check = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập Năm Bạn Muốn Kiểm Tra: ");
        year = input.nextShort();
        if(year%4 == 0){
            if(year%100 == 0){
                if(year%400 == 0){
                    check = true;
                }
            }else {
                check = true;
            }
        }
        if(check){
            System.out.printf("%d là năm nhuận.", year);
        }else {
            System.out.printf("%d không là năm nhuận.", year);
        }
    }
}
