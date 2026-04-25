package ecommerce_backend.repository;

import ecommerce_backend.model.ProductTable;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductTable , Integer> {
}
