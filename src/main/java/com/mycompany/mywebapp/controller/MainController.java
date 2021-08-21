package com.mycompany.mywebapp.controller;

import com.mycompany.mywebapp.domain.Student;
import com.mycompany.mywebapp.model.StudentModel;
import com.mycompany.mywebapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class MainController {

    @Autowired
    private StudentService studentService;
    private Object Student;
    private StudentModel student;
    private Long id;

    @PostMapping("/add-new-student")
    public HttpStatus addStudentPost(@RequestBody StudentModel student)
    {
        studentService.saveStudent(student);
        return HttpStatus.ACCEPTED;
    }

        @GetMapping("/get-all-student")
    public List<Student> getAllStudentGet()
    {
       return studentService.getAllStudents();
    }

    @GetMapping("/get-student/{id}")
    public Student getStudentGet(@PathVariable Long id)
    {
        return studentService.getStudent(id);
    }

    /*@GetMapping("/get-student")
    public Student showHomePage(@RequestParam Long id)
    {
        return studentService.getStudent(id);
    }*/

    @PutMapping("/update-student/{id}")
    public Student upDateStudentPut(@RequestBody StudentModel student, @PathVariable Long id){
        return studentService.updateStudent(student,id);
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity deleteStudentD( @PathVariable Long id)
    {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
