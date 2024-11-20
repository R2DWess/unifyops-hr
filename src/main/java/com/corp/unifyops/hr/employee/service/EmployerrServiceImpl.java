package com.corp.unifyops.hr.employee.service;

import com.corp.unifyops.hr.dto.EmployeeDTO;
import com.corp.unifyops.hr.employee.model.EmployeeData;
import com.corp.unifyops.hr.employee.repository.EmployeeRepository;
import com.corp.unifyops.hr.mapper.EmployeeMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployerrServiceImpl implements EmployerrService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployerrServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO register(EmployeeDTO employeeDTO) {
        EmployeeData employeeData = EmployeeMapper.INSTANCE.toEntity(employeeDTO);
        EmployeeData savedEmployee = employeeRepository.save(employeeData);
        return EmployeeMapper.INSTANCE.toDTO(savedEmployee);
    }

    @Transactional
    @Override
    public void delete(String employeeId) {
        employeeRepository.deleteByEmployeeId(employeeId);
    }

    @Override
    public EmployeeDTO update(String employeeId, EmployeeDTO employeeDTO) {
        Optional<EmployeeData>
                existingEmployee = employeeRepository.findByEmployeeId(employeeId);
        if (existingEmployee.isPresent()) {
            EmployeeData employeeData = existingEmployee.get();
            EmployeeMapper.INSTANCE.updateEntityFromDTO(employeeDTO, employeeData);
            EmployeeData updatedEmployee = employeeRepository.save(employeeData);
            return EmployeeMapper.INSTANCE.toDTO(updatedEmployee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + employeeId);
        }
    }
}