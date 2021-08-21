package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.domain.Student;
import com.mycompany.mywebapp.model.StudentModel;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentModel model);

    List<Student> getAllStudents();

    Object getStudent(Long id);

    Student updateStudent(StudentModel model,Long id);

    void deleteStudent(Long id);
}
