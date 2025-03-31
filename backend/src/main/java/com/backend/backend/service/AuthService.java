package main.java.com.backend.backend.service;

import main.java.com.backend.backend.model.User;
import main.java.com.backend.backend.repository.UserRepository;
//import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;
//import java.util.regex.PatternSyntaxException;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Regular Expressions for Validation
    private static final String PHONE_REGEX = "^[0-9]{10}$"; // 10-digit phone number
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{10,}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    // Register a new user
    public String registerUser(User user) {
        if (!user.getEmail().matches(EMAIL_REGEX)) {
            return "Invalid email format!";
        }
        if (!user.getPhoneNo().matches(PHONE_REGEX)) {
            return "Phone number must be exactly 10 digits!";
        }
        if (!user.getPassword().matches(PASSWORD_REGEX)) {
            return "Password must be at least 10 characters with one uppercase, one lowercase, one number, and one special character!";
        }

        // Check if user exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email is already registered!";
        }
        if (userRepository.findByPhoneNo(user.getPhoneNo()).isPresent()) {
            return "Phone number is already registered!";
        }

        // Hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    // Authenticate user (Login)
    public String loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            return "User not found!";
        }

        User user = userOptional.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "Invalid password!";
        }
        return "Login successful!";
    }

    // Get user by ID
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    // Update user details
    public String updateUser(Long userId, User updatedUser) {
        Optional<User> existingUserOpt = userRepository.findById(userId);
        if (existingUserOpt.isEmpty()) {
            return "User not found!";
        }

        User existingUser = existingUserOpt.get();

        // Update fields if provided
        if (updatedUser.getEmail() != null && updatedUser.getEmail().matches(EMAIL_REGEX)) {
            existingUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getPhoneNo() != null && updatedUser.getPhoneNo().matches(PHONE_REGEX)) {
            existingUser.setPhoneNo(updatedUser.getPhoneNo());
        }
        if (updatedUser.getPassword() != null && updatedUser.getPassword().matches(PASSWORD_REGEX)) {
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }

        userRepository.save(existingUser);
        return "User updated successfully!";
    }

    // Delete user by ID
    public String deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            return "User not found!";
        }

        userRepository.deleteById(userId);
        return "User deleted successfully!";
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
