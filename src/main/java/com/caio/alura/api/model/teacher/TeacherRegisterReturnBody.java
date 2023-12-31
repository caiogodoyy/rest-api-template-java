package com.caio.alura.api.model.teacher;

import com.caio.alura.api.enums.Department;
import com.caio.alura.api.enums.Gender;

public record TeacherRegisterReturnBody(String name, Gender gender, Department department, String state, String city) {
    
    public TeacherRegisterReturnBody(Teacher teacher) {
        this(teacher.getName(), teacher.getGender(), teacher.getDepartment(), teacher.getAddress().getState(), teacher.getAddress().getCity());
    }

}
