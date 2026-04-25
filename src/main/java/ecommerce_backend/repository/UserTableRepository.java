package ecommerce_backend.repository;
import ecommerce_backend.model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTableRepository extends JpaRepository<UserTable , Integer> {

//    @Query("select * from ecommerce_backend where email = ?1 and password = ?2")
    UserTable findByEmailAndPassword(String email , String password);
    // JPA generates the query automatically from the method name. This feature is called Query Method / Derived Query Method
}
