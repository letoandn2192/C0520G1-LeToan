package introduction_to_java.exercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Nhập Số Tiền USD Bạn Muốn Đổi: ");
        double moneyUSD = input.nextDouble();
        double moneyVND = moneyUSD * 23000;
        System.out.println("Số Tiền VND Tương Ứng là: " + df.format(moneyVND) + "VND");
    }
}
