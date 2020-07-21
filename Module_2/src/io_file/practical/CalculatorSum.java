package io_file.practical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CalculatorSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your pathname: ");
        String file = input.nextLine();
        //File file = new File("D:\\C0520G1-LeToan\\Module_2\\3.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            System.out.println("Sum is: " + sum);
            bufferedReader.close();
            fileReader.close();
        }catch (NumberFormatException e){
            System.out.println("Only number!!!");
        }catch (IOException e){
//            e.printStackTrace();
            System.out.println("Sai roi !!!");
        }
    }
}
