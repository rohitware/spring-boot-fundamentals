package com.rohit.spring_boot_fundamentals.dto;

import jakarta.validation.constraints.NotBlank;

public class StudentUpdateRequestDto {
    @NotBlank(message = "Student name cannot be blank")
    private String name;

    public StudentUpdateRequestDto() {

    }

    public StudentUpdateRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}