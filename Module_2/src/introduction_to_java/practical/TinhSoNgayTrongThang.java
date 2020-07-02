package introduction_to_java.practical;

import java.util.Scanner;

public class TinhSoNgayTrongThang {
    public static void main(String[] args) {
        final int JAN = 1, FEB = 2, MAR = 3, APR = 4, MAY = 5, JUN = 6, JUL = 7, AUG = 8, SEP = 9, OCT = 10, NOV = 11, DEC = 12;
        Scanner input = new Scanner(System.in);
        int month;
        String dayInMonth;
        System.out.println("Nhập Tháng Muốn Kiểm Tra.");
        month = input.nextInt();
        switch (month){
            case JAN:
            case MAR:
            case MAY:
            case JUL:
            case AUG:
            case OCT:
            case DEC:
                dayInMonth = "31";
                break;
            case APR:
            case JUN:
            case SEP:
            case NOV:
                dayInMonth = "30";
                break;
            case FEB:
                dayInMonth = "28 or 29";
                break;
            default:
                dayInMonth = "";
        }
        if(dayInMonth != ""){
            System.out.printf("The month %d has %s days!", month, dayInMonth);
        }else {
            System.out.println("Failed");
        }
    }
}
