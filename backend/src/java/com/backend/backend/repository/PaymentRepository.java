package java.com.backend.backend.repository;

import java.com.backend.backend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
    // Find payment associated with an order
    Optional<Payment> findByOrderId(Integer orderId);

    // Get all payments with a specific status
    List<Payment> findAllByPaymentStatus(String paymentStatus);
}
