package com.example.demo.seed;

import com.example.demo.assignment.entity.Council;
import com.example.demo.assignment.entity.StageTimeline;
import com.example.demo.assignment.seed.*;
import com.example.demo.department.entity.Department;
import com.example.demo.department.entity.Faculty;
import com.example.demo.department.seed.DepartmentSeeder;
import com.example.demo.department.seed.FacultySeeder;
import com.example.demo.department.seed.MajorSeeder;
import com.example.demo.department.seed.UserResearchSeeder;
import com.example.demo.user.entity.Research;
import com.example.demo.user.entity.Student;
import com.example.demo.user.seed.ResearchSeeder;
import com.example.demo.user.seed.StudentSeeder;
import com.example.demo.user.seed.TeacherSeeder;
import com.example.demo.user.seed.UserSeeder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {
    private final AcademySeeder academySeeder;
    private final FacultySeeder facultySeeder;
    private final DepartmentSeeder departmentSeeder;
    private final MajorSeeder majorSeeder;
    private final StudentSeeder studentSeeder;
    private final TeacherSeeder teacherSeeder;
    private final ProjectTermSeeder projectTermSeeder;
    private final StageTimelineSeeder stageTimelineSeeder;
    private final SupervisorSeeder supervisorSeeder;
    private final AssignmentSeeder assignmentSeeder;
    private final AssignmentSupervisorSeeder assignmentSupervisorSeeder;
    private final UserSeeder userSeeder;
    private final ResearchSeeder researchSeeder;
    private final UserResearchSeeder userResearchSeeder;

    @Override
    public void run(String... args) throws Exception {
        userSeeder.seed();
        academySeeder.seed();
        facultySeeder.seed();
        departmentSeeder.seed();
        majorSeeder.seed();
        studentSeeder.seed();
        teacherSeeder.seed();
        projectTermSeeder.seed();
        stageTimelineSeeder.seed();
        supervisorSeeder.seed();
        assignmentSeeder.seed();
        assignmentSupervisorSeeder.seed();
        researchSeeder.seed();
        userResearchSeeder.seed();
    }
}
