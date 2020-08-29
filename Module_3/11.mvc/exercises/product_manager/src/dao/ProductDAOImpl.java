package dao;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductDAOImpl implements ProductDAO {
    private static Map<Integer, Product> productList;

    static {
        productList = new TreeMap<>();
        productList.put(1, new Product(1, "Iphone", 1000, "This is...", "Apple"));
        productList.put(2, new Product(2, "Note 10", 1100, "This is...", "Samsung"));
        productList.put(3, new Product(3, "Zen Phone 3", 800, "This is...", "Asus"));
        productList.put(4, new Product(4, "Surface Pro", 900, "This is...", "Apple"));
        productList.put(5, new Product(5, "Nokia 5", 700, "This is...", "Nokia"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void create(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }
}
