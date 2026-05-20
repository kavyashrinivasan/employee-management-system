package com.kavya.employee.controller;

import com.kavya.employee.entity.Employee;
import com.kavya.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kavya.employee.DTO.EmployeeRequestDTO;
import com.kavya.employee.DTO.EmployeeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

   /* @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }*/
   @GetMapping
   public Page<Employee> getAll(Pageable pageable) {
       return service.getAllEmployees(pageable);
   }

   /* @PostMapping
    public Employee addEmployee(@Valid @RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }*/
   @PostMapping
   public EmployeeResponseDTO addEmployee(@Valid @RequestBody EmployeeRequestDTO dto) {
       return service.saveEmployee(dto);
   }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @Valid @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }
}