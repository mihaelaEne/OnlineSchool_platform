package org.example.onlineschool_platform.Profesor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.example.onlineschool_platform.System.Constants.EROARE_EXCEPTION;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class ErrException extends RuntimeException{
    public ErrException(){
        super(EROARE_EXCEPTION);
    }
}
