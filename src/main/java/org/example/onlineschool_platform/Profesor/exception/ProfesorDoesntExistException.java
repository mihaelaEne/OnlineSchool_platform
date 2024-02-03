package org.example.onlineschool_platform.Profesor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.example.onlineschool_platform.System.Constants.PROFESOR_DOESNT_EXIST;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class ProfesorDoesntExistException extends RuntimeException{
    public ProfesorDoesntExistException(){
        super(PROFESOR_DOESNT_EXIST);
    }
}
