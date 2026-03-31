package com.example.demo.user.entity;

import com.example.demo.assignment.entity.Supervisor;
import com.example.demo.department.entity.Department;
import com.example.demo.department.entity.DepartmentRole;
import com.example.demo.department.entity.LecturerSubject;
import com.example.demo.user.service.UserService;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teacher_code")
    private String teacherCode;

    @Column(name = "degree")
    private String degree;

    @Column(name = "position")
    private String position;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "teacher")
    private List<Supervisor> supervisorList;


    @OneToMany(mappedBy = "teacher")
    private List<DepartmentRole> departmentRoleList;

    @OneToMany(mappedBy = "teacher")
    private List<LecturerSubject> lecturerSubjectList;
}
