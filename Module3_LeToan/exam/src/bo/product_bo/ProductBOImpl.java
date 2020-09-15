package bo.product_bo;

import dao.product_dao.ProductDAOImpl;
import dao.product_dao.ProductDao;
import model.Product;

import java.util.List;

public class ProductBOImpl implements ProductBO {
    private ProductDao productDao = new ProductDAOImpl();

    @Override
    public List<Product> findAllProduct() {
        return productDao.findAllProduct();
    }

    @Override
    public Product findProductById(int id) {
        return productDao.findProductById(id);
    }

    @Override
    public boolean editProductInfo(Product product) {
        return productDao.editProductInfo(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productDao.deleteProduct(id);
    }

    @Override
    public void create(Product product) {
        productDao.create(product);
    }

    @Override
    public List<Product> search(String search) {
        return productDao.search(search);
    }
}
