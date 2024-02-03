package org.example.onlineschool_platform.Student.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.example.onlineschool_platform.System.Constants.NO_UPDATE;
@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class NoUpdateException extends RuntimeException {
    public NoUpdateException(){
        super(NO_UPDATE);

    }
}
