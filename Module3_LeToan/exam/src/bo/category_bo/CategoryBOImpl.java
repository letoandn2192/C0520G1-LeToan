package bo.category_bo;

import dao.category_dao.CategoryDAO;
import dao.category_dao.CategoryDAOImpl;
import model.Category;

import java.util.List;

public class CategoryBOImpl implements CategoryBO {
    private CategoryDAO categoryDAO = new CategoryDAOImpl();
    @Override
    public List<Category> findAllCategory() {
        return categoryDAO.findAllCategory();
    }
}
