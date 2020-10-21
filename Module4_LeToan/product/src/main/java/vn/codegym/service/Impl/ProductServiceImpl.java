package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.codegym.model.Product;
import vn.codegym.repository.ProductRepository;
import vn.codegym.service.ProductService;

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
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findProductColorOrName(String input, Pageable pageable) {
        return productRepository.findProductByProductColorContainingOrProductNameContaining(input, input, pageable);
    }

    @Override
    public Page<Product> findById(long id, Pageable pageable) {
        return productRepository.findProductByProductIdContaining(id, pageable);
    }

    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return productRepository.findProductByProductNameContaining(name, pageable);
    }

    @Override
    public Page<Product> findByQuantity(long quantity, Pageable pageable) {
        return productRepository.findProductByProductQuantityIsLessThan(quantity, pageable);
    }

    @Override
    public Page<Product> findByColor(String color, Pageable pageable) {
        return productRepository.findProductByProductColorContaining(color, pageable);
    }

    @Override
    public Page<Product> findByCategoryName(String name, Pageable pageable) {
        return productRepository.findProductByCategoryCategoryName(name, pageable);
    }

    @Override
    public List<Product> findAllSort(Sort sort) {
        return productRepository.findAll(sort.by("productId").descending().and(sort.by("productCost").descending()));
    }


}
