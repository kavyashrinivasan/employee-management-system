package com.kavya.employee.service;
import com.kavya.employee.DTO.*;
import com.kavya.employee.entity.Department;
import com.kavya.employee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public DepartmentResponseDTO saveDepartment(
            DepartmentRequestDTO dto) {

        Department department = new Department();

        department.setName(dto.getName());

        Department saved =
                repository.save(department);

        DepartmentResponseDTO response =
                new DepartmentResponseDTO();

        response.setId(saved.getId());
        response.setName(saved.getName());

        return response;
    }
}
