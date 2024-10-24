package com.application.repository;

import com.application.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByName(String name);

    List<Student> findByNameAndEmail(String name, String email);

    List<Student> findByNameOrEmail(String name, String email);

    // department.department_name
    List<Student> findByDepartmentDepartmentName(String departmentName);

    // subjects.subject_name
    List<Student> findBySubjectsSubjectName (String subjectName);
}
