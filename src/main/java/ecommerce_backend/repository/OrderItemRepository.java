package ecommerce_backend.repository;

import ecommerce_backend.model.OrderItemTable;
import ecommerce_backend.model.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemTable , Integer> {
    List<OrderItemTable> findByOrder(OrderTable order);
}
