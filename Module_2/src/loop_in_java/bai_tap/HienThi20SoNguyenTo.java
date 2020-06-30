package loop_in_java.bai_tap;

import java.util.Scanner;

public class HienThi20SoNguyenTo {
    public static void main(String[] args) {
        int count;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số số nguyên tố bạn muốn in: ");
        count = input.nextInt();
        int n = 2;
        String result = "";
        while (count > 0){
            boolean check = true;
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n%i == 0){
                    check = false;
                }
            }
            if(check){
                result += n + " ";
                count--;
            }
            n++;
        }
        System.out.println("Dãy số nguyên tố là: "+ result);
    }
}
