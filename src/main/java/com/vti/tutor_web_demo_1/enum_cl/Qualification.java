package com.vti.tutor_web_demo_1.enum_cl;

public enum Qualification {
    CU_NHAN_SU_PHAM("Cử nhân sư phạm"),
    SINH_VIEN_SU_PHAM("Sinh viên sư phạm"),
    GIAO_VIEN("Giáo viên"),
    SINH_VIEN("Sinh viên"),
    CULAN("Cử nhân"),
    THAC_SI("Thạc sĩ"),
    TIEN_SI("Tiến sĩ"),
    KY_SU("Kỹ sư"),
    BANG_KHAC("Bằng khác");

    private final String label;

    Qualification(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
