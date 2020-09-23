package vn.codegym.model;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private String productType;
    private String productProducer;

    public Product() {
    }

    public Product(String productName, double productPrice, int productQuantity, String productType, String productProducer) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productType = productType;
        this.productProducer = productProducer;
    }

    public Product(int productId, String productName, double productPrice, int productQuantity, String productType, String productProducer) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productType = productType;
        this.productProducer = productProducer;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductProducer() {
        return productProducer;
    }

    public void setProductProducer(String productProducer) {
        this.productProducer = productProducer;
    }
}
