package org.example.onlineschool_platform.Student.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.onlineschool_platform.Student.dtos.CreateStudentRequest;
import org.example.onlineschool_platform.Student.dtos.CreateStudentResponse;
import org.example.onlineschool_platform.Student.dtos.UpdateStudentRequest;
import org.example.onlineschool_platform.Student.model.Student;
import org.example.onlineschool_platform.Student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/online_school_platform")
@AllArgsConstructor
@Slf4j
public class StudentController {

    private StudentService studentService;

    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getAllStud() {
        List<Student> students=studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/createStudent")
    public ResponseEntity<CreateStudentResponse>addStud(@RequestBody CreateStudentRequest createStudentRequest){
        CreateStudentResponse createStudentResponse=studentService.addStudent(createStudentRequest);
        return new ResponseEntity<>(createStudentResponse,HttpStatus.CREATED);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable long id){
        studentService.deleteStud(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
