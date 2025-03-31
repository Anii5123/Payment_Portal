package main.java.com.backend.backend.repository;

import main.java.com.backend.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    // Find user by email (used for login)
    Optional<User> findByEmail(String email);

    // Get all users by role (Admin/User)
    List<User> findByRole(String role);

    // Find user by phone number
    Optional<User> findByPhoneNo(String phoneNo);

    // Check if email already exists
    boolean existsByEmail(String email);

    // Check if phone number already exists
    boolean existsByPhoneNo(String phoneNo);

    // Check if user exists by ID
    boolean existsById(Long id);

    // Find user by ID
    Optional<User> findById(Long id);

    // Retrieve all users

    // Delete user by ID
    void deleteById(Long id);

}
