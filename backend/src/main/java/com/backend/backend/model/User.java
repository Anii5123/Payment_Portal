package main.java.com.backend.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    @Column(length = 20)
    private String role = "User";

    @Column(name = "cancellation_count", columnDefinition = "INT DEFAULT 0")
    private Integer cancellationCount;

    @Column(name = "phone_no", nullable = false, unique = true, length = 10)
    private String phoneNo;
}
