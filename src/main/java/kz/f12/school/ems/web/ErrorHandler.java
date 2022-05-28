package kz.f12.school.ems.web;

import kz.f12.school.ems.exception.DeleteUsedRecordException;
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
    public ResponseEntity<?> handler(NullPointerException exception) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(exception.getMessage());
    }

    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<?> handler(ArrayIndexOutOfBoundsException exception) {
        return ResponseEntity.status(HttpStatus.OK)
                .body("ArrayIndexOutOfBoundsException");
    }

    @ExceptionHandler(value = DeleteUsedRecordException.class)
    public ResponseEntity<?> handler(DeleteUsedRecordException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorType.DELETE_USED_RECORD);
    }
}

enum ErrorType {
    DELETE_USED_RECORD
}
