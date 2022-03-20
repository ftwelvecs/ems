package kz.f12.school.ems.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = {
            NullPointerException.class,
            IllegalArgumentException.class
    })
    public ResponseEntity<Object> handler(NullPointerException exception) {
        System.out.println(exception);
        return ResponseEntity.status(HttpStatus.OK)
                .body(exception.getMessage());
    }

    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Object> handler(ArrayIndexOutOfBoundsException exception) {
        System.out.println(exception);
        return ResponseEntity.status(HttpStatus.OK)
                .body("ArrayIndexOutOfBoundsException");
    }

}
