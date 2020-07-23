package io_file_binary.exercises.binary_copy;

import java.io.*;

public class CopyFileBinary {
    public static void main(String[] args) {
        final String FILE_PATH_SOURCE = "D:\\C0520G1-LeToan\\Module_2\\source.txt";
        final String FILE_PATH_DESTINATION = "D:\\C0520G1-LeToan\\Module_2\\destination.txt";
        File file = new File(FILE_PATH_SOURCE);
        File file1 = new File(FILE_PATH_DESTINATION);
        if(!file.exists()){
            System.out.println("Find not Found!!!");
            System.exit(0);
        }
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(FILE_PATH_DESTINATION);
            DataInputStream input = new DataInputStream(fileInputStream);
            DataOutputStream output = new DataOutputStream(fileOutputStream);
            int byteRead;
            while ((byteRead = input.read()) != -1){
                output.write(byteRead);
            }
            System.out.println(file1.length());
            output.close();
            input.close();
            fileOutputStream.close();
            fileInputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
