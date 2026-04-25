package ecommerce_backend.repository;

import ecommerce_backend.model.CategoryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryTable, Integer> {
}
