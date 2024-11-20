package com.corp.unifyops.hr.employee.service;
import com.corp.unifyops.hr.dto.EmployeeDTO;
import com.corp.unifyops.hr.employee.model.EmployeeData;
import jakarta.transaction.Transactional;

public interface EmployerrService {

    EmployeeDTO register(EmployeeDTO employeeDTO);

    @Transactional
    void delete(String employeeId);

    EmployeeDTO update(String employeeId, EmployeeDTO employeeDTO);
}
