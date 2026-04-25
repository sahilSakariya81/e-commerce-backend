package ecommerce_backend.repository;

import ecommerce_backend.model.CartTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartTable, Integer> {

//    @Query(value = "select * from cart_table where user_id = ?1" , nativeQuery = true)
//    List<CartTable> findByUser(int userId);

    @Query(value = "select * from cart_table where user_id = ?1", nativeQuery = true)
    List<CartTable> findByUser(int userId);
}
