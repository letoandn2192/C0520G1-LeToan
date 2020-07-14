package collection_framework.exercises.arraylist;

public class Product{
    private String name;
    private int id;
    private double price;

    public Product( int amount,String name, double price) {
        this.name = name;
        this.id = amount;
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product { " +
                "id = " + this.id + '\'' +
                ", name = " + this.name +
                ", price = " + price +
                " }";
    }

}
