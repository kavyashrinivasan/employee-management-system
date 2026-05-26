package com.kavya.employee.DTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class EmployeeRequestDTO {


        @NotBlank(message = "Name cannot be empty")
        private String name;

        @Email(message = "Invalid email format")
        private String email;

        @NotBlank(message = "Role cannot be empty")
        private String role;

        @Min(value = 1, message = "Salary must be greater than 0")
        private Double salary;

        private Long departmentId;

        // GETTERS
        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getRole() {
            return role;
        }

        public Double getSalary() {
            return salary;
        }

        public Long getDepartmentId() {
            return departmentId;
        }

        // SETTERS
        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public void setDepartmentId(Long departmentId) {
            this.departmentId = departmentId;
        }
}
