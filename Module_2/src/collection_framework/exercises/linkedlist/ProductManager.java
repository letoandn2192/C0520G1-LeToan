package collection_framework.exercises.linkedlist;

import java.util.*;

public class ProductManager{
    private List<Product> listProduct = new LinkedList<>();
    Scanner input = new Scanner(System.in);
    public void addNewProduct(){
        int id;
        String name;
        double price;
        boolean isExist;
        do {
            isExist = false;
            System.out.println("Enter product's id: ");
            id = input.nextInt();
            for(int i = 0; i < listProduct.size(); i++){
                if(listProduct.get(i).getId() == id){
                    isExist = true;
                    break;
                }
            }
        }while (id < 0 || isExist);
        System.out.println("Enter product's name: ");
        name = input.nextLine();
        name = input.nextLine();
        do{
            System.out.println("Enter product's price: ");
            price = input.nextDouble();
        }while (price < 0);
        listProduct.add(new Product(id, name, price));
        System.out.println("Successful");
    }

    public void editInformation(int id){
        boolean isExist = false;
        for(Product product: listProduct){
            if(product.getId() == id){
                System.out.println(product);
                System.out.println("Enter new name: ");
                product.setName(input.nextLine());
                product.setName(input.nextLine());
                System.out.println("Enter new price: ");
                product.setPrice(input.nextDouble());
                isExist = true;
                break;
            }
        }
        if(!isExist){
            System.out.println("Not found!!!");
        }
    }

    public Product delete(int id){
        Product temp = null;
        boolean isExist = false;
        for(Product product: listProduct){
            if(product.getId() == id){
                temp = product;
                isExist = true;
                break;
            }
        }

        if(isExist){
            listProduct.remove(temp);
            System.out.println("Successful!!!");
        }else {
            System.out.println("No exist !!!");
        }
        return temp;
    }

    public void showListProduct(){
        if(listProduct.isEmpty()){
            System.out.println("List is empty!!!");
        }else {
            System.out.printf("%-3s%-5s%-10s%-10s", "", "Id", "Product", "Price");
            int count = 0;
            for (Product product : listProduct) {
                System.out.println();
                System.out.printf("%-3d%-5d%-10s%-10.2f", ++count, product.getId(), product.getName(), product.getPrice());
            }
            System.out.println();
        }
    }

//    public Product search(String name){
////        Product temp = null;
////        boolean isExist = false;
////        for(Product product: listProduct){
////            if(name.equals(product.getName())){
////                temp = product;
////                isExist = true;
////                break;
////            }
////        }
////
////        if(isExist){
////            System.out.println(temp);;
////        }else {
////            System.out.println("No exist !!!");
////        }
////        return temp;
////    }

    public void search(String name){
        List<Product> listTemp = new LinkedList<>();
        for(Product product: listProduct){
            if(product.getName().contains(name)){
                listTemp.add(product);
            }
        }

        if(!listTemp.isEmpty()){
            System.out.printf("%-3s%-5s%-10s%-10s", "", "Id", "Product", "Price");
            int count = 0;
            for(Product product: listTemp){
                System.out.println();
                System.out.printf("%-3d%-5d%-10s%-10.2f", ++count, product.getId(), product.getName(), product.getPrice());
            }
            System.out.println();
        }else {
            System.out.println("No exist !!!");
        }
    }

    public void sort(){
        System.out.println("1. AscendingSort");
        System.out.println("2. DecreaseSort");
        System.out.println("Enter your choice: ");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                Collections.sort(listProduct, new AscendingSort());
                break;
            case 2:
                Collections.sort(listProduct, new DecreaseSort());
                break;
            default:
                System.out.println("Invalid value!!!");
        }
    }
}
