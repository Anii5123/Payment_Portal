package java.com.backend.backend.repository;

import java.com.backend.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    // Find user by email (used for login)
    Optional<User> findByEmail(String email);

    // Get all users by role (Admin/User)
    List<User> findByRole(String role);
}
