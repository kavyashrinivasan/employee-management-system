package com.kavya.employee.controller;
import com.kavya.employee.DTO.*;
import com.kavya.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @PostMapping
    public DepartmentResponseDTO addDepartment(
            @RequestBody DepartmentRequestDTO dto) {

        return service.saveDepartment(dto);
    }
}
