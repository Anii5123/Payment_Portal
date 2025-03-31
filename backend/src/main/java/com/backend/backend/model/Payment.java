package main.java.com.backend.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "payment_date", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime paymentDate;

    @Column(name = "payment_status", length = 50, nullable = false)
    private String paymentStatus;

    @Column(name = "payment_mode", length = 50, nullable = false)
    private String paymentMode;
}
