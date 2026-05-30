package com.kavya.employee.DTO;

public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String role;


    private DepartmentResponseDTO department;
    private AddressResponseDTO address;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public String getRole() {

        return role;
    }
    public void setRole(String role) {

        this.role = role;
    }

    public DepartmentResponseDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentResponseDTO department) {
        this.department = department;
    }

    public AddressResponseDTO getAddress() {
        return address;
    }

    public void setAddress(AddressResponseDTO address) {
        this.address = address;
    }
}
