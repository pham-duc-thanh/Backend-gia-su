package com.vti.tutor_web_demo_1.entity;


import com.vti.tutor_web_demo_1.enum_cl.Status;
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
//  Lịch học
@Document(collection = "schedules")
public class Schedule {
    @Id
    private Long scheduleId;
    @DBRef
    private Tutor tutor;
    @DBRef
    private Parent parent;
    private LocalDateTime startTime; // Thời gian bắt đầu
    private LocalDateTime endTime; // Thời gian kết thúc
    private Status status; // Đã xác nhận, đang chờ, đã hủy, v.v.Confirmed, pending, canceled

    // Constructors, getters, setters
}
