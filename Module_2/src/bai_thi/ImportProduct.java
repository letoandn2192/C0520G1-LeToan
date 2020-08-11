package bai_thi;

import java.util.List;
import java.util.Scanner;

public class ImportProduct extends Product {
    private double importPrice;
    private String importCity;
    private double importTax;

    public ImportProduct() {
    }

    public ImportProduct(int id, String code, String name, double price, int amount, String producer, double importPrice, String importCity, double importTax) {
        super(id, code, name, price, amount, producer);
        this.importPrice = importPrice;
        this.importCity = importCity;
        this.importTax = importTax;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public String getImportCity() {
        return importCity;
    }

    public void setImportCity(String importCity) {
        this.importCity = importCity;
    }

    public double getImportTax() {
        return importTax;
    }

    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-10s%-10s%-10.2f%-10d%-10s%-10.2f%-10s%.2f", super.getId(), super.getCode(), super.getName(), super.getPrice(),
                 super.getAmount(),super.getProducer(), this.importPrice, this.importCity, this.importTax);
    }

    public void addImportProduct() {
        Scanner input = new Scanner(System.in);
        List<Product> productList = Manager.getProductList();
        if(productList.size() != 0) {
            super.setId(productList.get(productList.size()-1).getId() + 1);
        } else {
            super.setId(1);
        }
        System.out.println("Enter code product");
        super.setCode(Regex.checkCode(input.nextLine()));
        System.out.println("Enter name product");
        super.setName(Regex.checkNull(input.nextLine()));
        System.out.println("Enter price product");
        super.setPrice(Regex.checkNumberDouble(input.nextLine()));
        System.out.println("Enter amount of product");
        super.setAmount(Regex.checkNumberInt(input.nextLine()));
        System.out.println("Enter producer");
        super.setProducer(Regex.checkNull(input.nextLine()));
        System.out.println("Enter import price");
        this.setImportPrice(Regex.checkNumberDouble(input.nextLine()));
        System.out.println("Enter import city");
        this.setImportCity(Regex.checkNull(input.nextLine()));
        System.out.println("Enter import tax");
        this.setImportTax(Regex.checkNumberDouble(input.nextLine()));
        productList.add(this);
        Manager.setProductList(productList);
    }
}
