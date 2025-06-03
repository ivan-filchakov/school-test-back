package com.example.school_test.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleInvalidEnum(HttpMessageNotReadableException ex) {
        if (ex.getCause() instanceof InvalidFormatException e) {
            String targetType = e.getTargetType().getSimpleName();
            String field = e.getPath().get(0).getFieldName();
            String invalidValue = e.getValue().toString();

            return ResponseEntity
                    .badRequest()
                    .body(Map.of(
                        "error", "Invalid enum value",
                        "field", field,
                        "invalid", invalidValue,
                        "expected", getEnumConstants(targetType)
                    ));
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", "Invalid request", "message", ex.getMessage()));
    }

    private List<String> getEnumConstants(String enumName) {
        try {
            Class<?> enumClass = Class.forName("com.example.school_test.model." + enumName);
            Object[] constants = enumClass.getEnumConstants();
            List<String> values = new ArrayList<>();
            for (Object c : constants) {
                values.add(c.toString());
            }
            return values;
        } catch (Exception e) {
            return List.of();
        }
    }
}
