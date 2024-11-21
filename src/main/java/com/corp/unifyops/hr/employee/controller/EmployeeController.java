package com.corp.unifyops.hr.employee.controller;

import com.corp.unifyops.hr.dto.EmployeeDTO;
import com.corp.unifyops.hr.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeDTO register(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.register(employeeDTO);
    }

    @PatchMapping("/{employeeId}")
    public EmployeeDTO update(@PathVariable String employeeId, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.update(employeeId, employeeDTO);
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable String employeeId) {
        employeeService.delete(employeeId);
    }
}
