package com.rohit.spring_boot_fundamentals.dto;

public class StudentResponseDto {

    private int id;
    private String name;

    public StudentResponseDto() {

    }

    public StudentResponseDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
