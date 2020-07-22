package io_file_binary.practical;

import javax.xml.crypto.Data;
import java.io.*;

public class Test {
    public static void main(String[] args) {
        String[] array = {"a", "b", "c"};
        try{
            FileOutputStream file = new FileOutputStream("D:\\C0520G1-LeToan\\Module_2\\1.txt");
            DataOutputStream output = new DataOutputStream(file);
            for(int i = 0 ; i < array.length; i++){
                output.writeUTF(array[i]);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        try {
            FileInputStream file = new FileInputStream("D:\\C0520G1-LeToan\\Module_2\\1.txt");
            DataInputStream input = new DataInputStream(file);
            while(true) {
                try {
                    String a = input.readUTF();
                    System.out.println(a);
                }
                catch(EOFException eof) {
                    System.out.println ("End of File");
                    break;
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
