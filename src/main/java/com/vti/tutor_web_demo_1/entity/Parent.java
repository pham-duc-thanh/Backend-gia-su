package com.vti.tutor_web_demo_1.entity;

import com.vti.tutor_web_demo_1.enum_cl.Gender;
import com.vti.tutor_web_demo_1.enum_cl.Role;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "parents")
public class Parent {
    @Id
    private String parentId;
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    private String username;
    private String email;
    private String password;
    private String fullname;
    private String phone;
    private LocalDateTime createdDate;
    private Role role; // user, admin, tutor
}
