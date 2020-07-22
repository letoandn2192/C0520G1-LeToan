package io_file_binary.exercises.product_manage;

public class Product implements java.io.Serializable{
    private int codeProduct;
    private String nameProduct;
    private String branchProduct;
    private double priceProduct;

    public Product(int codeProduct, String nameProduct, String branchProduct, double priceProduct) {
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.branchProduct = branchProduct;
        this.priceProduct = priceProduct;
    }

    public Product() {
    }

    public int getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(int codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getBranchProduct() {
        return branchProduct;
    }

    public void setBranchProduct(String branchProduct) {
        this.branchProduct = branchProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-20s%-20s%.2f", this.getCodeProduct(), this.getNameProduct(), this.getBranchProduct(), this.getPriceProduct());
    }
}
