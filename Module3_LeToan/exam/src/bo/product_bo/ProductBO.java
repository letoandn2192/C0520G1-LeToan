package bo.product_bo;

import model.Product;

import java.util.List;

public interface ProductBO {
    List<Product> findAllProduct();

    Product findProductById(int id);

    boolean editProductInfo(Product product);

    boolean deleteProduct(int id);

    void create(Product product);

    List<Product> search(String search);
}
