package bai_thi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private static List<Product> productList = new ArrayList<>();
    private static final String PRODUCT_FILE_PATH = "D:\\C0520G1-LeToan\\Module_2\\src\\product.csv";
    private static final String BLANK = "";
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";

    public static List<Product> getProductList() {
        return productList;
    }

    public static void setProductList(List<Product> productList) {
        Manager.productList = productList;
    }

    public void displayMenu() {
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println(Display.mainMenu());
            System.out.print("Enter your choice: ");
            choice = Regex.checkNumberInt(input.nextLine());
            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    showProductList();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    writeFile();
                    System.exit(0);
                default:
                    System.out.println("Invalid value!!!");
            }
        }
    }

    public void addNewProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println(Display.addProductMenu());
        System.out.print("Enter your select: ");
        int select = Regex.checkNumberInt(input.nextLine());
        switch (select) {
            case 1:
                ImportProduct importProduct = new ImportProduct();
                importProduct.addImportProduct();
                break;
            case 2:
                ExportProduct exportProduct = new ExportProduct();
                exportProduct.addExportProduct();
                break;
            case 3:
                displayMenu();
                break;
            case 4:
                writeFile();
                System.exit(0);
            default:
                System.out.println("Invalid value.");
        }
    }

    public void showProductList(){
        List<Product> productList = Manager.getProductList();
        if(productList.size() != 0){
            for(Product product: productList){
                if(product instanceof ImportProduct){
                    ImportProduct productTemp = (ImportProduct) product;
                    System.out.println(productTemp);
                } else {
                    ExportProduct productTemp = (ExportProduct) product;
                    System.out.println(productTemp);
                }
            }
        } else {
            System.out.println("List is Empty!!!");
        }
    }

    public void removeProduct() {
        boolean isExist = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter code product you want to remove: ");
        String code = input.nextLine();
        Product removeProduct = null;
        for (Product product: productList){
            if(code.equals(product.getCode())){
                isExist = true;
                removeProduct = product;
            }
        }

        if(isExist) {
            System.out.println("Do you want to remove this product!!!");
            char select = input.next().toLowerCase().charAt(0);
            if(select == 'y') {
                productList.remove(removeProduct);
                showProductList();
            } else {
                displayMenu();
            }
        } else {
            try {
                throw new NotFoundProductException("Product is not exist!!!");
            } catch (NotFoundProductException e) {
                e.getMessage();
            }
        }
    }

    public void searchProduct(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter code or name of product: ");
        String searchProduct = input.nextLine();
        for (Product product: productList){
            if(product.getName().contains(searchProduct) || product.getCode(). contains(searchProduct)) {
                if(product instanceof ImportProduct){
                    ImportProduct productTemp = (ImportProduct) product;
                    System.out.println(productTemp);
                } else {
                    ExportProduct productTemp = (ExportProduct) product;
                    System.out.println(productTemp);
                }
            }
        }
    }

    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter(PRODUCT_FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product element : productList) {
                bufferedWriter.append(String.valueOf(element.getId()));
                bufferedWriter.append(COMMA);
                bufferedWriter.append(element.getCode());
                bufferedWriter.append(COMMA);
                bufferedWriter.append(element.getName());
                bufferedWriter.append(COMMA);
                bufferedWriter.append(String.valueOf(element.getPrice()));
                bufferedWriter.append(COMMA);
                bufferedWriter.append(String.valueOf(element.getAmount()));
                bufferedWriter.append(COMMA);
                bufferedWriter.append(element.getProducer());
                bufferedWriter.append(COMMA);
                if(element instanceof ImportProduct) {
                    ImportProduct importProduct = (ImportProduct) element;
                    bufferedWriter.append(String.valueOf(importProduct.getImportPrice()));
                    bufferedWriter.append(COMMA);
                    bufferedWriter.append(importProduct.getImportCity());
                    bufferedWriter.append(COMMA);
                    bufferedWriter.append(String.valueOf(importProduct.getImportTax()));
                } else {
                    ExportProduct exportProduct = (ExportProduct) element;
                    bufferedWriter.append(String.valueOf(exportProduct.getExportPrice()));
                    bufferedWriter.append(COMMA);
                    bufferedWriter.append(exportProduct.getExportNation());
                }
                bufferedWriter.append(NEW_LINE);
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() throws IOException {
        File file = new File(PRODUCT_FILE_PATH);
        if(!file.exists()){
            file.createNewFile();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String  code, name, producer, importCity, exportNation;
        int id, amount;
        double price, importPrice, importTax, exportPrice;
        String[] arrayData;
        String data;
        while ((data = bufferedReader.readLine()) != null) {
            if (BLANK.equals(data)) {
                break;
            } else {
                arrayData = data.split(",");
                id = Integer.parseInt(arrayData[0]);
                code = arrayData[1];
                name = arrayData[2];
                price = Double.parseDouble(arrayData[3]);
                amount = Integer.parseInt(arrayData[4]);
                producer = arrayData[5];
                if (arrayData.length == 9) {
                    importPrice = Double.parseDouble(arrayData[6]);
                    importCity = arrayData[7];
                    importTax = Double.parseDouble(arrayData[8]);
                    ImportProduct importProduct = new ImportProduct(id, code, name, price, amount, producer, importPrice, importCity, importTax);
                    productList.add(importProduct);
                } else {
                    exportPrice = Double.parseDouble(arrayData[6]);
                    exportNation = arrayData[7];
                    ExportProduct exportProduct = new ExportProduct(id, code, name, price, amount, producer, exportPrice, exportNation);
                    productList.add(exportProduct);
                }
            }
        }

        bufferedReader.close();
        fileReader.close();
    }
}
