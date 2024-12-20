package me.ayushdhar.ProductService.ControllerAdvice;

import me.ayushdhar.ProductService.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                productNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND
        );
        return responseEntity;
    }
}
