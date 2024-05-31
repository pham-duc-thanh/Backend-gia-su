package com.vti.tutor_web_demo_1.controller;

import com.vti.tutor_web_demo_1.dto.ParentDTO;
import com.vti.tutor_web_demo_1.entity.Parent;
import com.vti.tutor_web_demo_1.enum_cl.Role;
import com.vti.tutor_web_demo_1.repository.ParentRepository;
import com.vti.tutor_web_demo_1.request.LoginRequest;
import com.vti.tutor_web_demo_1.service.IParentService;
import com.vti.tutor_web_demo_1.service.impl.ParentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/parents")
public class ParentController {

    @Autowired
    private ParentServiceImpl parentService;

    @Autowired
    private ParentRepository parentRepository;

    @GetMapping
    public ResponseEntity<List<Parent>> getAllParents() {
        List<Parent> parents = parentService.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.OK);
    }

    @GetMapping("/{parentId}")
    public ResponseEntity<Parent> getParentById(@PathVariable("parentId") String parentId) {
        Parent parent = parentService.getParentById(parentId);
        if (parent != null) {
            return new ResponseEntity<>(parent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent) {
        Parent createdParent = parentService.createParent(parent);
        return new ResponseEntity<>(createdParent, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody  LoginRequest loginRequest) {
        String result = parentService.login(loginRequest);
        if (result.equals("Login successful")) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{parentId}")
    public ResponseEntity<Parent> updateParent(@PathVariable("parentId") String parentId, @RequestBody Parent parent) {
        if (parent != null) {
            Parent updatedParent = parentService.updateParent(parentId, parent);
            if (updatedParent != null) {
                return new ResponseEntity<>(updatedParent, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



    @DeleteMapping("/{parentId}")
    public ResponseEntity<Void> deleteParent(@PathVariable("parentId") String parentId) {
        parentService.deleteParent(parentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
