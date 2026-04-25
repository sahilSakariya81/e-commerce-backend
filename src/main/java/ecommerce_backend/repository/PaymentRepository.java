package ecommerce_backend.repository;

import ecommerce_backend.model.PaymentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends JpaRepository<PaymentTable , Integer> {

    @Query(value = "select * from payment_table where user_id = ?1" , nativeQuery = true)
    PaymentTable findByUserId(int orderId);

}
