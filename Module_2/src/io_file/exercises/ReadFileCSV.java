package io_file.exercises;

import java.io.*;

public class ReadFileCSV {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\C0520G1-LeToan\\Module_2\\Text.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] data;
            while ((line = bufferedReader.readLine()) != null){
                data = line.split(",");
                System.out.println(data[5]);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
