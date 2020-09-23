package vn.codegym.repository;

import vn.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> productList;
    private static List<String> productType;

    static {
        productType = new ArrayList<>();
        productType.add("Phone");
        productType.add("Television");
        productType.add("Laptop");
        productType.add("Air Condition");
        productList = new TreeMap<>();
        productList.put(1, new Product(1, "Iphone X", 1000, 100, "Phone", "Apple"));
        productList.put(2, new Product(2, "Note 10", 1000, 100, "Phone", "SamSung"));
        productList.put(3, new Product(3, "LG Bravo 4K", 1000, 100, "Television", "LG"));
        productList.put(4, new Product(4, "Dell N4110", 1000, 100, "Laptop", "Dell"));
    }

    @Override
    public List<String> getProductType() {
        return productType;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getProductId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }
}
