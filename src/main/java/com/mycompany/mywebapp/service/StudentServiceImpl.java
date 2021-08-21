package com.mycompany.mywebapp.service;

import com.mycompany.mywebapp.domain.Student;
import com.mycompany.mywebapp.model.StudentModel;
import com.mycompany.mywebapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void saveStudent(StudentModel model) {
        Student student = new Student();
        student.setAddress(model.getAddress());
        student.setFirstName(model.getFirstName());
        student.setLastName(model.getLastName());
      studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @Override
    public Student getStudent(Long id ) {
        Optional<Student> optionalStudent = studentRepository.findById((long) id);
        if (optionalStudent.isPresent()){
            return optionalStudent.get();
        }
        return  null;
    }



    @Override
    public Student updateStudent(StudentModel model, Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = new Student();
        if(optionalStudent.isPresent()){
            student = optionalStudent.get();
        }

        student.setAddress(model.getAddress());
        student.setFirstName(model.getFirstName());
        student.setLastName(model.getLastName());
        studentRepository.save(student);

        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
        }


    }




