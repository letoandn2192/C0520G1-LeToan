package bo;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;

import java.util.List;

public class ProductBOImpl implements ProductBO {
    private ProductDAO productDAO = new ProductDAOImpl();
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public void create(Product product) {
        productDAO.create(product);
    }

    @Override
    public void update(int id, Product product) {
        productDAO.update(id, product);
    }

    @Override
    public void delete(int id) {
        productDAO.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }
}
