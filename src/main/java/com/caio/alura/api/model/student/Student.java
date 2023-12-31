package com.caio.alura.api.model.student;

import com.caio.alura.api.enums.Gender;
import com.caio.alura.api.model.address.Address;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "students")
@Entity(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean active;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String grade;
    private String phone;

    @Embedded
    private Address address;

    public Student(StudentRegisterData data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.gender = data.gender();
        this.grade = data.grade();
        this.phone = data.phone();
        this.address = new Address(data.address());
    }

    public void deactivate() {
        this.active = false;
    }

}
