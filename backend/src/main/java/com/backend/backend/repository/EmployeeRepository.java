package main.java.com.backend.backend.repository;

import main.java.com.backend.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    // Find employee by email (used for login)
    Optional<Employee> findByEmail(String email);

    // Get all employees by role (Employee/Manager)
    List<Employee> findByRole(String role);
}

