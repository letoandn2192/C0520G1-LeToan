package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class TinhChiSoCanNangCoThe {
    public static void main(String[] args) {
        float weight;
        float height;
        float bmi;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập Cân Nặng: ");
        weight = input.nextFloat();
        System.out.println("Nhập Chiều Cao: ");
        height = input.nextFloat();
        bmi = weight / (height * height);
        if(bmi < 18.5){
            System.out.printf("bmi: %-5.2f is Underweight", bmi);
        }else if( bmi < 25){
            System.out.printf("bmi: %-5.2f is Normal", bmi);
        }else if(bmi < 30){
            System.out.printf("bmi: %-5.2f is Overweight", bmi);
        }else {
            System.out.printf("bmi: %-5.2f is Obese", bmi);
        }
    }
}
