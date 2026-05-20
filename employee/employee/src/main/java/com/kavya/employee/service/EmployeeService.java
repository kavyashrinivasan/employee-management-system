package com.kavya.employee.service;

import com.kavya.employee.entity.Employee;
import com.kavya.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kavya.employee.exception.EmployeeNotFoundException;
import com.kavya.employee.DTO.EmployeeRequestDTO;
import com.kavya.employee.DTO.EmployeeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

  /*  public List<Employee> getAllEmployees() {
        return repository.findAll();
    }*/
  public Page<Employee> getAllEmployees(Pageable pageable) {
      return repository.findAll(pageable);
  }

    /*public Employee saveEmployee(Employee emp) {
        return repository.save(emp);
    }*/
    public EmployeeResponseDTO saveEmployee(EmployeeRequestDTO dto) {

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setRole(dto.getRole());
        employee.setSalary(dto.getSalary());

        Employee savedEmployee = repository.save(employee);
        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();

        responseDTO.setId(savedEmployee.getId());
        responseDTO.setName(savedEmployee.getName());
        responseDTO.setEmail(savedEmployee.getEmail());
        responseDTO.setRole(savedEmployee.getRole());

        return responseDTO;
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

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}
