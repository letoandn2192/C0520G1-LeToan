package vn.codegym.product_manager.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.product_manager.model.Category;
import vn.codegym.product_manager.repository.CategoryRepository;
import vn.codegym.product_manager.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveAndUpdate(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        categoryRepository.deleteById(id);
    }
}
