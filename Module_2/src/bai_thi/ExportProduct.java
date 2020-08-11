package bai_thi;

import java.util.List;
import java.util.Scanner;

public class ExportProduct extends Product {
    private double exportPrice;
    private String exportNation;

    public ExportProduct() {
    }

    public ExportProduct(int id, String code, String name, double price, int amount, String producer, double exportPrice, String exportNation) {
        super(id, code, name, price, amount, producer);
        this.exportPrice = exportPrice;
        this.exportNation = exportNation;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getExportNation() {
        return exportNation;
    }

    public void setExportNation(String exportNation) {
        this.exportNation = exportNation;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-10s%-10s%-10.2f%-10d%-10s%-10.2f%s", super.getId(), super.getCode(), super.getName(), super.getPrice(),
                super.getAmount(), super.getProducer(), this.exportPrice, this.exportNation);
    }

    public void addExportProduct() {
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
        System.out.println("Enter export price");
        this.setExportPrice(Regex.checkNumberDouble(input.nextLine()));
        System.out.println("Enter export nation");
        this.setExportNation(Regex.checkNull(input.nextLine()));
        productList.add(this);
        Manager.setProductList(productList);
    }


}
