package array_and_method_in_array.exercises;

import java.util.Scanner;

public class TimGTNNTrongMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập độ dài mảmg: ");
        int size = input.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            array[i] = (int)(Math.floor(Math.random() * 100));
        }
        System.out.print("Mảng được tao: ");
        for (int element: array){
            System.out.print(element + " ");
        }
        int min = array[0];
        for(int element:array){
            if(min > element){
                min = element;
            }
        }
        System.out.println();
        System.out.print("GTNN của mảng là: " + min);
    }
}
