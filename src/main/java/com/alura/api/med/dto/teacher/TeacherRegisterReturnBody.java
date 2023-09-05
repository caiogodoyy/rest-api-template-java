package com.alura.api.med.dto.teacher;

import com.alura.api.med.domain.teacher.Teacher;

public record TeacherRegisterReturnBody(String name, Gender gender, String department, String state, String city) {
    
    public TeacherRegisterReturnBody(Teacher teacher) {
        this(teacher.getName(), teacher.getGender(), teacher.getDepartment(), teacher.getAddress().getState(), teacher.getAddress().getCity());
    }

}
