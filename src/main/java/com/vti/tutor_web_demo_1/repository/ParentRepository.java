package com.vti.tutor_web_demo_1.repository;

import com.vti.tutor_web_demo_1.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ParentRepository  extends MongoRepository<Parent, String> {
    Parent findByParentId(String parentId);

    Parent findByEmail(String email);

    boolean existsByEmail(String email);
}
