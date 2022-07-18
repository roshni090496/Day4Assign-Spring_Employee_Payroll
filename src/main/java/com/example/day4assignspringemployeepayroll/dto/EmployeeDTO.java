package com.example.day4assignspringemployeepayroll.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@RequiredArgsConstructor
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="Employee name Invalid" )

    public String name;
    public String gender;
    public String department;
    public long salary;


}
