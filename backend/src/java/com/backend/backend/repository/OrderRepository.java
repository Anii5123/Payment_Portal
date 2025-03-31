package java.com.backend.backend.repository;

import java.com.backend.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
    // Get all orders placed by a specific user
    List<Order> findAllByUserId(Integer userId);

    // Get all orders based on order status
    List<Order> findAllByOrderStatus(String orderStatus);
}
