package main.java.com.backend.backend.repository;

import main.java.com.backend.backend.model.EmployeeOrderAction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeOrderActionRepository extends JpaRepository<EmployeeOrderAction, Integer> {
    
    // Get all actions performed by a specific employee
    List<EmployeeOrderAction> findAllByEmployeeId(Integer employeeId);

    // Get all actions taken on a specific order
    List<EmployeeOrderAction> findAllByOrderId(Integer orderId);
}
