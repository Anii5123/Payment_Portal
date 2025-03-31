package java.com.backend.backend.repository;

import java.com.backend.backend.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    
    // Get bill details based on order ID
    Optional<Bill> findByOrderId(Integer orderId);
}
