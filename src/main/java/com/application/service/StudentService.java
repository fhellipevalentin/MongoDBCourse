package com.application.service;

import com.application.entity.Student;
import com.application.repository.StudentRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Student getStudentById(String id) {
        return repository.findById(id).get();
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student updateStudent(String id, Student student) {
        return repository.findById(id).map(recordFound -> {
            recordFound.setName(student.getName());
            recordFound.setEmail(student.getEmail());
            recordFound.setDepartment(student.getDepartment());
            recordFound.setSubjects(student.getSubjects());
            return repository.save(recordFound);
        }).orElseThrow(()-> new RuntimeException("Student not found"));
    }

    public List<Student> studentsByName(String name) {
        return repository.findByName(name);
    }

    public List<Student> studentByNameAndEmail(String name, String email) {
        return repository.findByNameAndEmail(name, email);
    }

    public List<Student> studentByNameOrEmail(String name, String email) {
        return repository.findByNameOrEmail(name, email);
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        return repository.findAll(pageable).getContent();
    }

    public List<Student> byDepartmentName(String department) {
        return repository.findByDepartmentDepartmentName(department);
    }

    public List<Student> bySubjectName(String subjectName) {
        return repository.findBySubjectsSubjectName(subjectName);
    }
}
