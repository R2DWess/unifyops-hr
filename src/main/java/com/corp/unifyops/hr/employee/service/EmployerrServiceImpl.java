package com.corp.unifyops.hr.employee.service;

import com.corp.unifyops.hr.employee.model.EmployeeData;
import com.corp.unifyops.hr.employee.repository.EmployeeRepository;
import com.corp.unifyops.hr.employee.identifier.EmployeeIdGenerator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployerrServiceImpl implements EmployerrService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeIdGenerator employeeIdGenerator;

    @Override
    public EmployeeData register(EmployeeData employeeData) {
        employeeData.setEmployeeId(employeeIdGenerator.uniqueIdGenerator());
        return employeeRepository.save(employeeData);
    }

    @Transactional
    @Override
    public void delete(String employeeId) {
        employeeRepository.deleteByEmployeeId(employeeId);
    }

    @Override
    public EmployeeData update(String employeeId, EmployeeData employeeData) {

        Optional<EmployeeData> existingEmployee = employeeRepository.findByEmployeeId(employeeId);
        if (existingEmployee.isPresent()){
            EmployeeData employee = getEmployeeData(employeeData, existingEmployee);
            return employeeRepository.save(employee);

        } else {
            throw new RuntimeException("Employee not found with idFuncional: " + employeeId);
        }
    }

    private static EmployeeData getEmployeeData(EmployeeData employeeData, Optional<EmployeeData> existingEmployee) {
        EmployeeData employee = existingEmployee.get();
        if (employeeData.getName() != null) {
            employee.setName(employeeData.getName());
        }
        if (employeeData.getAge() != null) {
            employee.setAge(employeeData.getAge());
        }
        if (employeeData.getEmployeeAddress() != null) {
            employee.setEmployeeAddress(employeeData.getEmployeeAddress());
        }
        return employee;
    }
}

