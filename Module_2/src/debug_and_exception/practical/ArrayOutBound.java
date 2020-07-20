package debug_and_exception.practical;

import test.hashmap.Map;

import java.util.Scanner;

public class ArrayOutBound {
    public static  int[] createArrayRandom(){
        int[] arrayRandom = new int[100];
        for(int i = 0; i < arrayRandom.length; i++){
            arrayRandom[i] = (int) Math.floor(Math.random() * 100);
        }
        return arrayRandom;
    }

    public static void main(String[] args) {
        int[] array = createArrayRandom();
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter index you want!!!");
            int index = input.nextInt();
            System.out.println(array[index]);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index out of array of ");
        }
    }
}
