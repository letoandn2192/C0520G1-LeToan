package collection_framework.exercises.arraylist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManager listProduct = new ProductManager();
        while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Add New Product: ");
            System.out.println("2. Edit Information: ");
            System.out.println("3. Delete Product: ");
            System.out.println("4. Show Information: ");
            System.out.println("5. Search Product By Name: ");
            System.out.println("6. Sort Product By Price: ");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    listProduct.addNewProduct();
                    break;
                case 2:
                    System.out.println("Enter Id you want to edit: ");
                    int index = input.nextInt();
                    listProduct.editInformation(index);
                    break;
                case 3:
                    listProduct.showListProduct();
                    System.out.println("Enter product's id you want to remove: ");
                    int id = input.nextInt();
                    listProduct.delete(id);
                    break;
                case 4:
                    listProduct.showListProduct();
                    break;
                case 5:
                    System.out.println("Enter your product's name: ");
                    String name = input.nextLine();
                    name = input.nextLine();
                    listProduct.search(name);
                    break;
                case 6:
                    listProduct.sort();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid value");
            }
        }
    }
}
