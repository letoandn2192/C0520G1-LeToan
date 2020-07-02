package introduction_to_java.exercises;

import java.util.Scanner;

public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số cần đọc: ");
        int number = input.nextInt();
        String result = "";
        if (number >= 0 && number < 1000) {
            int hundred = number / 100;
            number = number % 100;
            switch (hundred){
                case 0:
                    result += "";
                    break;
                case 1:
                    result += "One hundred ";
                    break;
                case 2:
                    result += "Two hundred ";
                    break;
                case 3:
                    result += "Three hundred ";
                    break;
                case 4:
                    result += "Four hundred ";
                    break;
                case 5:
                    result += "Five hundred ";
                    break;
                case 6:
                    result += "Six hundred ";
                    break;
                case 7:
                    result += "Seven hundred ";
                    break;
                case 8:
                    result += "Eight hundred ";
                    break;
                case 9:
                    result += "Nine hundred ";
                    break;
            }
            int integer = number / 10;
            int modulo = number % 10;
            if(hundred !=0 && number !=0){
                result += "and ";
            }
            if (integer != 1) {
                switch (integer) {
                    case 0:
                        result += "";
                        break;
                    case 2:
                        result += "Twenty ";
                        break;
                    case 3:
                        result += "Thirty ";
                        break;
                    case 4:
                        result += "Forty ";
                        break;
                    case 5:
                        result += "Fifty ";
                        break;
                    case 6:
                        result += "Sixty ";
                        break;
                    case 7:
                        result += "Seventy ";
                        break;
                    case 8:
                        result += "Eighty ";
                        break;
                    case 9:
                        result += "Ninety ";
                        break;
                }
                switch (modulo) {
                    case 0:
                        if (integer == 0 && hundred == 0) {
                            result += "Zero";
                        }
                        break;
                    case 1:
                        result += "One";
                        break;
                    case 2:
                        result += "Two";
                        break;
                    case 3:
                        result += "Three";
                        break;
                    case 4:
                        result += "Four";
                        break;
                    case 5:
                        result += "Five";
                        break;
                    case 6:
                        result += "Six";
                        break;
                    case 7:
                        result += "Seven";
                        break;
                    case 8:
                        result += "Eight";
                        break;
                    case 9:
                        result += "Nine";
                        break;
                }
            } else {
                switch (number) {
                    case 10:
                        result += "Ten";
                        break;
                    case 11:
                        result += "Eleven";
                        break;
                    case 12:
                        result += "Twelve";
                        break;
                    case 13:
                        result += "Thirteen";
                        break;
                    case 14:
                        result += "Fourteen";
                        break;
                    case 15:
                        result += "Fifteen";
                        break;
                    case 16:
                        result += "Sixteen";
                        break;
                    case 17:
                        result += "Seventeen";
                        break;
                    case 18:
                        result += "Eighteen";
                        break;
                    case 19:
                        result += "Nineteen";
                        break;

                }
            }
        } else {
            result = "Out of ability";
        }
        System.out.printf("%s ", result);
    }
}
