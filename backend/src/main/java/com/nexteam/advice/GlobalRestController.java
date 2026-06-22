package com.nexteam.advice;

import com.nexteam.common.ApiResponse;
import com.nexteam.exception.AlreadyExistException;
import com.nexteam.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Classe 'GlobalRestController' en charge de
 *
 * @author jnsualu2026
 * @since 2026-06-19
 */
@RestControllerAdvice
public class GlobalRestController{

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handlePathNotFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.of(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null));
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ApiResponse<?>> handleAlreadyExist(AlreadyExistException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiResponse.of(HttpStatus.CONFLICT.value(), ex.getMessage(), null));
    }
}
