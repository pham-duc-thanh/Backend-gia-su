package com.vti.tutor_web_demo_1.entity;

import com.vti.tutor_web_demo_1.enum_cl.PaymentStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// Thanh toán
@Document(collection = "payments")
public class Payment {
    @Id
    private Long paymentId;
    @DBRef
    private Tutor tutor; // Tham chiếu đến TutorProfile
    @DBRef
    private Parent parent; // Tham chiếu đến User
    private BigDecimal paymentAmount;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentDate;

    // Constructors, getters, setters
}
