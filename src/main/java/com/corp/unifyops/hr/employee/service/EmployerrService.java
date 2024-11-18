package com.corp.unifyops.hr.employee.service;


import com.corp.unifyops.hr.employee.model.EmployeeData;
import jakarta.transaction.Transactional;

public interface EmployerrService {
    EmployeeData register(EmployeeData employeeData);


    @Transactional
    void delete(String idFuncional);

    EmployeeData update(String idFuncional, EmployeeData employeeData);


}
