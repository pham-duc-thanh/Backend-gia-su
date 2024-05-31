package com.vti.tutor_web_demo_1.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// Đánh giá
@Document(collection = "reviews")
public class Review {
    @Id
    private Long reviewId;
    @DBRef
    private Tutor tutor;
    @DBRef
    private Parent parent;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;

    // Constructors, getters, setters
}
