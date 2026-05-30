package com.kavya.employee.DTO;

public class DepartmentResponseDTO {
    private Long id;
    private String name;


    // GETTERS
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
