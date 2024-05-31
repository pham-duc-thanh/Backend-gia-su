package com.vti.tutor_web_demo_1.dto;

import com.vti.tutor_web_demo_1.enum_cl.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParentDTO {
    private String parentId;
    private String username;
    private String email;
    private String password;
    private String fullname;
    private String phone;
    private LocalDateTime createdDate;
    private Role role; // user, admin, tutor
}
