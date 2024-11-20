package com.corp.unifyops.hr.employee.controller;

import com.corp.unifyops.hr.dto.EmployeeDTO;
import com.corp.unifyops.hr.employee.service.EmployerrService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployerrService employerrService;

    @Autowired
    public EmployeeController(EmployerrService employerrService) {
        this.employerrService = employerrService;
    }

    @PostMapping
    public EmployeeDTO register(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return employerrService.register(employeeDTO);
    }

    @PatchMapping("/{employeeId}")
    public EmployeeDTO update(@PathVariable String employeeId, @RequestBody EmployeeDTO employeeDTO) {
        return employerrService.update(employeeId, employeeDTO);
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable String employeeId) {
        employerrService.delete(employeeId);
    }
}
