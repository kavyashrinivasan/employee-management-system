package com.kavya.employee.service;

import com.kavya.employee.entity.Employee;
import com.kavya.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee saveEmployee(Employee emp) {
        return repository.save(emp);
    }
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee emp = repository.findById(id).orElseThrow();

        emp.setName(updatedEmployee.getName());
        emp.setEmail(updatedEmployee.getEmail());
        emp.setRole(updatedEmployee.getRole());
        emp.setSalary(updatedEmployee.getSalary());

        return repository.save(emp);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
