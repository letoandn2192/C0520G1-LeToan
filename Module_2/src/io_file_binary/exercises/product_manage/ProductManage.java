package io_file_binary.exercises.product_manage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
    public static List<Product> productList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void addNewProduct() {
        System.out.println("Enter code product: ");
        int codeProduct = input.nextInt();
        System.out.println("Enter name product: ");
        input.nextLine();
        String nameProduct = input.nextLine();
        System.out.println("Enter branch product");
        String branchProduct = input.nextLine();
        System.out.println("Enter price product");
        double priceProduct = input.nextDouble();
        Product product = new Product(codeProduct, nameProduct, branchProduct, priceProduct);
        productList.add(product);
        writeFile();
        System.out.println("Successful!!!");
    }

    public void showInformation() {
        int count = 0;
        System.out.printf("%-4s%-5s%-20s%-20s%s", "", "Code", "Name", "Branch", "Price");
        System.out.println();
        for (Product product : productList) {
            System.out.printf("%-4d%-5d%-20s%-20s%.2f", ++count, product.getCodeProduct(), product.getNameProduct(),
                    product.getBranchProduct(), product.getPriceProduct());
            System.out.println();
        }
    }

    public void search(String name) {
        boolean isExist = false;
        for (Product product : productList) {
            if (name.equals(product.getNameProduct())) {
                System.out.println("Found");
                System.out.println(product);
                isExist = true;
            }
        }
        if (!isExist) {
            System.out.println("No Found !!!");
        }
    }

    public void writeFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\C0520G1-LeToan\\Module_2\\Text.csv");
            ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
            output.writeObject(productList);
            output.flush();
            output.close();
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFile(){
        //File file = new File("D:\\C0520G1-LeToan\\Module_2\\Text.csv");
        FileInputStream fileInputStream = null;
        ObjectInputStream input  = null;
//        if (!file.exists()) {
//            System.out.println("File is not exist!!!");
//            System.exit(0);
//        }
        try {
            fileInputStream = new FileInputStream("D:\\C0520G1-LeToan\\Module_2\\Text.csv");
            input = new ObjectInputStream(fileInputStream);
            productList.clear();
            List<Product> a;
            if ((a = (List<Product>) input.readObject()) != null) {
                productList = a;
            }
            input.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
