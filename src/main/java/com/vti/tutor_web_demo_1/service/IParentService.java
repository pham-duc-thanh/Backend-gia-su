package com.vti.tutor_web_demo_1.service;

import com.vti.tutor_web_demo_1.dto.ParentDTO;
import com.vti.tutor_web_demo_1.entity.Parent;
import com.vti.tutor_web_demo_1.request.LoginRequest;

import java.util.List;

public interface IParentService {
    List<Parent> getAllParents();
    Parent getParentById(String parentId);
    Parent createParent(Parent parent);
    Parent updateParent(String parentId, Parent parent);
    void deleteParent(String parentId);

    String login(LoginRequest loginRequest);
}
