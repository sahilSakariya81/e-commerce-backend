package ecommerce_backend.repository;

import ecommerce_backend.model.CouponTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<CouponTable, Integer> {

    CouponTable findByCode(String code);
}
