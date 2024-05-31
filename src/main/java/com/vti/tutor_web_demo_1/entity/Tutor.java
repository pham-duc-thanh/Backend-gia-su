package com.vti.tutor_web_demo_1.entity;

import com.vti.tutor_web_demo_1.enum_cl.Gender;
import com.vti.tutor_web_demo_1.enum_cl.Qualification;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "tutors")
public class Tutor {
    @Id
    private Long tutorId;
    private Parent parent;

    private List<String> teachingTimes; // Danh sách thời gian dạy

    private String province; // tỉnh
    private String teachingArea; // quận, huyện
    private Gender gender; // Giới tính
    private Date dateOfBirth;
    private String hometown; // Mguyên quán
    private String currentAddress; // Địa chỉ hiện tại
    private String cardPhoto; // Ảnh thẻ
    private String frontIdCardPhoto; // Ảnh trước CCCD
    private String backIdCardPhoto; // Ảnh sau CCCD
    private String diplomahoto; // Ảnh bằng cấp
    private String schoolOrUniversity; // Sinh viên , giáo viên trường
    private String major; // ngành học
    private int yearOfGraduation; // năm tốt nghiệp
    private Qualification qualification; // nghề nghiệp hiện tại
    @DBRef
    private List<Class> classes;
    @DBRef
    private List<Subject> subjects;
    private String teachingTime; // Thời gian dạy
    private double salaryRequirement; // lương
    private String otherRequirements;  // yêu cầu khác
//    private String securityCode; // mã bảo vệ
}
