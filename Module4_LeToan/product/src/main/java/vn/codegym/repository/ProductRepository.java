package vn.codegym.repository;

        import org.apache.catalina.LifecycleState;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.domain.Sort;
        import org.springframework.data.jpa.repository.JpaRepository;
        import vn.codegym.model.Product;

        import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findProductByProductColorContainingOrProductNameContaining (String color, String name, Pageable pageable);

    Page<Product> findProductByProductIdContaining (long id, Pageable pageable);

    Page<Product> findProductByProductNameContaining (String name, Pageable pageable);

    Page<Product> findProductByProductQuantityIsLessThan (long input, Pageable pageable);

    Page<Product> findProductByProductColorContaining(String input, Pageable pageable);

    Page<Product> findProductByCategoryCategoryName(String input, Pageable pageable);

    List<Product> findAll(Sort sort);
}
