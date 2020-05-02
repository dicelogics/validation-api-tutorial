package com.dicelogics.tutorial.validation.controller.advice;

import com.dicelogics.tutorial.validation.model.error.ValidationError;
import com.dicelogics.tutorial.validation.model.error.ValidationErrorEntry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ErrorControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        Map<String, List<ValidationErrorEntry>> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            String field = error.getField();
            if (!errors.containsKey(field)) {
                errors.put(field, new ArrayList<>());
            }
            errors.get(field).add(new ValidationErrorEntry(error.getCode(), error.getDefaultMessage()));
        }

        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            String objectName = error.getObjectName();
            if (!errors.containsKey(objectName)) {
                errors.put(objectName, new ArrayList<>());
            }
            errors.get(objectName).add(new ValidationErrorEntry(error.getCode(), error.getDefaultMessage()));
        }

        ValidationError validationError = new ValidationError(HttpStatus.BAD_REQUEST, errors);
        return handleExceptionInternal(ex, validationError, headers, validationError.getHttpStatus(), request);
    }
}
