package ra.springboot_practice_relationship.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.springboot_practice_relationship.exception.NotFoundException;

@RestControllerAdvice
public class ApiControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFount(NotFoundException e){
        return e.getMessage();
    }
}
