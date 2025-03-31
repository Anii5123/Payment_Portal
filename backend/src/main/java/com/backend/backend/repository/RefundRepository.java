package main.java.com.backend.backend.repository;

import main.java.com.backend.backend.model.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RefundRepository extends JpaRepository<Refund, Integer> {
    
    // Get all refunds by status (Pending, Processed, Failed)
    List<Refund> findAllByRefundStatus(String refundStatus);

    // Find refund details based on a specific payment transaction
    Optional<Refund> findByPaymentId(Integer paymentId);
}
