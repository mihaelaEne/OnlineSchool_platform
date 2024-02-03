package org.example.onlineschool_platform.Student.service;

import jakarta.transaction.Transactional;
import org.example.onlineschool_platform.Student.dtos.CreateStudentRequest;
import org.example.onlineschool_platform.Student.dtos.CreateStudentResponse;
import org.example.onlineschool_platform.Student.dtos.UpdateStudentRequest;
import org.example.onlineschool_platform.Student.exception.ErrException;
import org.example.onlineschool_platform.Student.exception.NoUpdateException;
import org.example.onlineschool_platform.Student.exception.StudentDoesntExistException;
import org.example.onlineschool_platform.Student.exception.StudentExistException;
import org.example.onlineschool_platform.Student.model.Student;
import org.example.onlineschool_platform.Student.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {

    private StudentRepo studentRepo;
    public List<Student> getAllStudents(){
        List<Student>all=studentRepo.findAll();
        if(all.size()==0){
            throw new ErrException();
        }
        return all;
    }


    @Transactional

    public CreateStudentResponse addStudent(CreateStudentRequest createStudentRequest){

        Optional<Student> studentByName=studentRepo.findStudentByFulName(createStudentRequest.getFullName());

        if(studentByName.isPresent()){
            throw  new StudentExistException();
        }

        Student student= Student.builder()
                .fullName(createStudentRequest.getFullName())
                .email(createStudentRequest.getEmail())
                .password(createStudentRequest.getPassword())
                .phone(createStudentRequest.getPhone())
                .build();


        Student student1=studentRepo.saveAndFlush(student);

        return CreateStudentResponse.builder().student(student1).build();
    }

    @Transactional
    public void deleteStud(long id){
        Optional<Student>student=studentRepo.findById(id);
        if(student.isPresent()){
            studentRepo.delete(student.get());
        }else{
            throw new StudentDoesntExistException();
        }
    }




}
