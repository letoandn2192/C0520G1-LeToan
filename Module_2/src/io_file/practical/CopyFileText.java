package io_file.practical;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) {
        File file = new File("D:\\C0520G1-LeToan\\Module_2\\1.txt");
        if (!file.exists()) {
            System.exit(0);
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter("D:\\C0520G1-LeToan\\Module_2\\2.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.write("\n");
            }

            bufferedReader.close();
            bufferedWriter.close();
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
