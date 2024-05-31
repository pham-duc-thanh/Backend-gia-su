package com.vti.tutor_web_demo_1.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "classes")
class Class {
    @Id
    private Long classId;
    private String className;
}
