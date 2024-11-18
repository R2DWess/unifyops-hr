package com.corp.unifyops.hr.employee.controller;

import com.corp.unifyops.hr.employee.identifier.EmployeeIdGenerator;
import com.corp.unifyops.hr.employee.model.EmployeeData;
import com.corp.unifyops.hr.employee.service.EmployerrService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class EmployeeController {

    private final EmployerrService employerrService;
    private final EmployeeIdGenerator employeeIdGenerator;

    @Autowired
    public EmployeeController(EmployerrService employerrService, EmployeeIdGenerator employeeIdGenerator) {
        this.employerrService = employerrService;
        this.employeeIdGenerator = employeeIdGenerator;
    }

    @PostMapping
    public EmployeeData employeeRegister(@Valid @RequestBody EmployeeData employeeData) {
        employeeData.setEmployeeId(employeeIdGenerator.uniqueIdGenerator());
        return employerrService.register(employeeData);
    }

    @PatchMapping("/{employeeId}")
    public EmployeeData employeeUpdate(@PathVariable String employeeId, @RequestBody EmployeeData employeeData) {
        return employerrService.update(employeeId, employeeData);
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable String idFuncional){
        employerrService.delete(idFuncional);
    }
}