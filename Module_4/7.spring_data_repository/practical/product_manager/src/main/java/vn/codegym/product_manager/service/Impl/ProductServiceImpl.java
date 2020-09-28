package vn.codegym.product_manager.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.product_manager.model.Product;
import vn.codegym.product_manager.repository.ProductRepository;
import vn.codegym.product_manager.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void saveAndUpdate(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteProductInBatch(List<Long> idList) {
//        productRepository.deleteProductsByProductIdIn(idList);
        for (long id:idList) {
            productRepository.delete(findById(id));
        }
    }

    @Override
    public Page<Product> searchByName(String name, Pageable pageable) {
        return productRepository.findByProductNameContaining(name, pageable);
    }
}
