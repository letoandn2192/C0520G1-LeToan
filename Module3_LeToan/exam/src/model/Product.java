package model;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private int productAmount;
    private String productColor;
    private String productDescription;
    private int productCategoryId;

    public Product() {
    }

    public Product(String productName, double productPrice, int productAmount, String productColor, String productDescription, int productCategoryId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.productColor = productColor;
        this.productDescription = productDescription;
        this.productCategoryId = productCategoryId;
    }

    public Product(int productId, String productName, double productPrice, int productAmount, String productColor, String productDescription, int productCategoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.productColor = productColor;
        this.productDescription = productDescription;
        this.productCategoryId = productCategoryId;
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

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
}
