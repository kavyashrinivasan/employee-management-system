package com.kavya.employee.service;

import com.kavya.employee.DTO.AddressResponseDTO;
import com.kavya.employee.DTO.DepartmentResponseDTO;
import com.kavya.employee.entity.Address;
import com.kavya.employee.entity.Department;
import com.kavya.employee.entity.Employee;
import com.kavya.employee.repository.DepartmentRepository;
import com.kavya.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kavya.employee.exception.EmployeeNotFoundException;
import com.kavya.employee.DTO.EmployeeRequestDTO;
import com.kavya.employee.DTO.EmployeeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import java.awt.print.Pageable;

import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

  /*  public List<Employee> getAllEmployees() {
        return repository.findAll();
    }*/
  @Autowired
  private DepartmentRepository departmentRepository;
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

        if (dto.getDepartmentId() != null) {
            Department department = departmentRepository.findById(dto.getDepartmentId())
                            .orElseThrow(() -> new RuntimeException("Department not found"));
            employee.setDepartment(department);
        }
        Address address = new Address();
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPincode(dto.pincode());
        employee.setAddress(address);

        Employee savedEmployee = repository.save(employee);
        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();

        responseDTO.setId(savedEmployee.getId());
        responseDTO.setName(savedEmployee.getName());
        responseDTO.setEmail(savedEmployee.getEmail());
        responseDTO.setRole(savedEmployee.getRole());

        return responseDTO;
    }

    private EmployeeResponseDTO mapToDTO(Employee employee) {

        EmployeeResponseDTO dto = new EmployeeResponseDTO();

        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setRole(employee.getRole());


        // Department Mapping
        if (employee.getDepartment() != null) {

            DepartmentResponseDTO departmentDTO =
                    new DepartmentResponseDTO();

            departmentDTO.setId(
                    employee.getDepartment().getId());

            departmentDTO.setName(
                    employee.getDepartment().getName());

            dto.setDepartment(departmentDTO);
        }

        // Address Mapping
        if (employee.getAddress() != null) {

            AddressResponseDTO addressDTO =
                    new AddressResponseDTO();

            addressDTO.setId(employee.getAddress().getId());
            addressDTO.setCity(employee.getAddress().getCity());
            addressDTO.setState(employee.getAddress().getState());
            addressDTO.setPincode(employee.getAddress().getPincode());

            dto.setAddress(addressDTO);
        }

        return dto;
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

   /* public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }*/
   public EmployeeResponseDTO getEmployeeById(Long id) {

       Employee employee = repository
               .findById(id)
               .orElseThrow(() ->
                       new RuntimeException("Employee not found"));

       return mapToDTO(employee);
   }

   /* public List<Employee> searchByName(String name){
        return repository.findByNameContainingIgnoreCase(name);
    }*/
    public Page<EmployeeResponseDTO> searchEmployees(String name, Pageable pageable) {
        Page<Employee> employeePage = repository.findByNameContainingIgnoreCase(name, pageable);
        return employeePage.map(employee -> {
            EmployeeResponseDTO dto = new EmployeeResponseDTO();
            dto.setId(employee.getId());
            dto.setName(employee.getName());
            dto.setEmail(employee.getEmail());
            dto.setRole(employee.getRole());

            return dto;
        });
    }

    public List<EmployeeResponseDTO> getEmployeesByDepartment(Long departmentId) {

        List<Employee> employees =
                repository.findByDepartmentId(departmentId);

        return employees.stream()
                .map(this::mapToDTO)
                .toList();
    }
}
