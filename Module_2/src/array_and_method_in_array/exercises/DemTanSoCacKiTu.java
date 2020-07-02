package array_and_method_in_array.exercises;

import java.util.Scanner;

public class DemTanSoCacKiTu {
    public static void main(String[] args) {
        int countChar = 0;
        int index = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi bạn muốn kiểm tra: ");
        String checkString = input.nextLine();
        char[] arrayChar = new char[checkString.length()];
        int[] arrayFrequency = new int[arrayChar.length];


        for(int i = 0; i < checkString.length(); i++){
            boolean flag = false;
            char temp = checkString.charAt(i);
            for(int j = 0; j < countChar; j++){
                if(arrayChar[j] == checkString.charAt(i)){
                    flag = true;
                    index = j;
                    break;
                }
            }
            if(flag){
                arrayFrequency[index] += 1;
            }else {
                arrayChar[countChar] = temp;
                arrayFrequency[countChar] += 1;
                countChar++;
            }
        }
        for (char value : arrayChar) {
            System.out.print(value + "\t");
        }
        System.out.println();
        for (int value : arrayFrequency) {
            System.out.print(value + "\t");
        }
    }
}
