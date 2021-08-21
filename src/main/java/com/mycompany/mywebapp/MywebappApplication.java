package com.mycompany.mywebapp;



import  com.mycompany.mywebapp.service.StudentService;
import com.mycompany.mywebapp.service.StudentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MywebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MywebappApplication.class, args);
    }

    @Bean
    public StudentService studentService(){
        return new StudentServiceImpl();
    }

}
