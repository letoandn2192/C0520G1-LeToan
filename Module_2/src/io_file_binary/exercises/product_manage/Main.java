package io_file_binary.exercises.product_manage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManage productManage = new ProductManage();
        productManage.readFile();
        while (true){
            System.out.println("Menu");
            System.out.println("1. Add New Product");
            System.out.println("2. Show Information");
            System.out.println("3. Search Information");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    productManage.addNewProduct();
                    break;
                case 2:
                    productManage.showInformation();
                    break;
                case 3:
                    System.out.println("Enter name product: ");
                    input.nextLine();
                    String name = input.nextLine();
                    productManage.search(name);
                    break;
                case 4:
                    productManage.writeFile();
                    System.exit(0);
                default:
                    System.out.println("Invalid value !!!");
            }
        }
        }
}
