package com.rohit.spring_boot_fundamentals.dto;

public class StudentRequestDto {

    private String name;

    public StudentRequestDto() {
    }

    public StudentRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}