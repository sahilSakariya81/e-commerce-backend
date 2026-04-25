package ecommerce_backend.repository;

import ecommerce_backend.model.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderTable  , Integer> {
}
