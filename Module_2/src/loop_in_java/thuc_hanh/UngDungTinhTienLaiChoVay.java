package loop_in_java.thuc_hanh;

import java.text.DecimalFormat;
import java.util.Scanner;

public class UngDungTinhTienLaiChoVay {
    public static void main(String[] args) {
        double moneySend;
        int month;
        double intersetRate;
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Nhập số tiền bạn muốn gửi VND: ");
        moneySend = input.nextDouble();
        System.out.println("Nhập số tháng bạn muốn gửi: ");
        month = input.nextInt();
        System.out.println("Nhập lãi suất năm %: ");
        intersetRate = input.nextDouble();
        double moneyReceive = 0;
        moneyReceive = moneySend * (intersetRate / 100) / 12 * month;
        System.out.println(df.format(moneyReceive) + " VND");
    }
}
