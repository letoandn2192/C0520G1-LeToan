package io_file_binary.practical;

import javax.xml.crypto.Data;
import java.io.*;

public class Test {
    public static void main(String[] args) {
        char[] array = {'a', 'b', 'c'};
        try{
            FileOutputStream file = new FileOutputStream("D:\\C0520G1-LeToan\\Module_2\\1.txt");
            DataOutputStream output = new DataOutputStream(file);
            for(int i = 0 ; i < array.length; i++){
                output.writeChar(array[i]);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        try {
            FileInputStream file = new FileInputStream("D:\\C0520G1-LeToan\\Module_2\\1.txt");
            DataInputStream input = new DataInputStream(file);
            char[] array1 = new char[3];
            for(int i = 0; i < array1.length; i++){
                array1[i] = input.readChar();
            }
            for(char a: array1){
                System.out.println(a);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
