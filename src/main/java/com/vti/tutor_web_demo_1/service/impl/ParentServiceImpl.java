package com.vti.tutor_web_demo_1.service.impl;

import com.vti.tutor_web_demo_1.database.SequenceGeneratorService;
import com.vti.tutor_web_demo_1.dto.ParentDTO;
import com.vti.tutor_web_demo_1.entity.Parent;
import com.vti.tutor_web_demo_1.enum_cl.Role;
import com.vti.tutor_web_demo_1.repository.ParentRepository;
import com.vti.tutor_web_demo_1.request.LoginRequest;
import com.vti.tutor_web_demo_1.service.IParentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParentServiceImpl implements IParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;


    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public Parent getParentById(String parentId) {
        Optional<Parent> parentOptional = parentRepository.findById(parentId);
        return parentOptional.orElse(null);
    }

    @Override
    public Parent createParent(Parent parent) {
        // Kiểm tra xem email đã tồn tại trong cơ sở dữ liệu chưa
        if (parentRepository.existsByEmail(parent.getEmail())) {
            throw new DataIntegrityViolationException("Email đã tồn tại");
        }

        // Tạo một bản ghi mới nếu email chưa tồn tại
        Long id = sequenceGeneratorService.generateSequence(Parent.SEQUENCE_NAME);
        parent.setParentId(String.valueOf(id));
        parent.setRole(Role.USER);
        parent.setCreatedDate(LocalDateTime.now());
        return parentRepository.save(parent);
    }

    @Override
    public Parent updateParent(String parentId, Parent parent) {
        Optional<Parent> parentOptional = parentRepository.findById(parentId);
        if (parentOptional.isPresent()) {
            Parent parentToUpdate = parentOptional.get();
            parentToUpdate.setUsername(parent.getUsername());
            parentToUpdate.setEmail(parent.getEmail());
            parentToUpdate.setPassword(parent.getPassword());
            parentToUpdate.setFullname(parent.getFullname());
            parentToUpdate.setPhone(parent.getPhone());
            parentToUpdate.setRole(Role.USER); // Cập nhật role nếu cần
            parentToUpdate.setCreatedDate(LocalDateTime.now());
            return parentRepository.save(parentToUpdate);
        }
        return null;
    }

    @Override
    public void deleteParent(String parentId) {
        parentRepository.deleteById(parentId);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        // Tìm parent trong cơ sở dữ liệu dựa trên email
        Parent parent = parentRepository.findByEmail(email);

        // Kiểm tra xem parent có tồn tại và mật khẩu khớp không
        if (parent != null && parent.getPassword().equals(password)) {
            return "Login successful"; // Trả về thông báo thành công nếu tồn tại và mật khẩu khớp
        } else {
            return "Invalid email or password"; // Trả về thông báo lỗi nếu email không tồn tại hoặc mật khẩu không khớp
        }
    }
}
