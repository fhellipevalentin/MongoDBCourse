package com.application.controller;


import com.application.entity.Student;
import com.application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable String id) {
        return studentService.updateStudent(id, student);
    }

    @GetMapping("/sudentsByName/{name}")
    public List<Student> sudentsByName(@PathVariable String name) {
        return studentService.studentsByName(name);
    }

    // operadpr AND
    @GetMapping("/studentsByNameAndEmail")
    public List<Student> studentsByNameAndEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.studentByNameAndEmail(name, email);
    }

    // operador OR
    @GetMapping("/studentsByNameOREmail")
    public List<Student> studentsByNameOREmail(@RequestParam String name, @RequestParam String email) {
        return studentService.studentByNameOrEmail(name, email);
    }
}
