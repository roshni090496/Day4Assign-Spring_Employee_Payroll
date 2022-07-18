package com.example.day4assignspringemployeepayroll.exception;
import com.example.day4assignspringemployeepayroll.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

    @ControllerAdvice
    public class CustomException {
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
            List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
            List<String> errmsg = errorList.stream().map(objErr -> objErr.getDefaultMessage())
                    .collect(Collectors.toList());
            ResponseDTO respDTO = new ResponseDTO("Exception while processing rest request",errmsg);
            return new ResponseEntity<>(respDTO, HttpStatus.BAD_REQUEST);
        }
        @ExceptionHandler(EmployeePayrollException.class)
        public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception){
            ResponseDTO respDTO = new ResponseDTO("Exception while processing REST request",
                    exception.getMessage());
            return new ResponseEntity<>(respDTO, HttpStatus.BAD_REQUEST);
        }
    }

