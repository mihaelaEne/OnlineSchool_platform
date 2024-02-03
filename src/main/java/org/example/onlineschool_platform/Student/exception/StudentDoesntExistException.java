package org.example.onlineschool_platform.Student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.example.onlineschool_platform.System.Constants.PROFESOR_DOESNT_EXIST;
import static org.example.onlineschool_platform.System.Constants.STUDENT_DOESNT_EXIST;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class StudentDoesntExistException extends RuntimeException{
    public StudentDoesntExistException(){
        super(STUDENT_DOESNT_EXIST);
    }
}
