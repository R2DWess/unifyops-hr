package com.corp.unifyops.hr.utils;

import com.corp.unifyops.hr.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmployeeIdGenerator {

    private static final int EMPLOYEE_ID_LENGTH = 9;

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Generates a unique functional ID with exactly 9 numeric digits,
     * checking if the ID already exists in the database.
     */
    public String uniqueIdGenerator() {
        String id;
        do {
            id = IdGenerator();
        } while (employeeRepository.existsByEmployeeId(id)); // Check if the ID already exists
        return id;
    }

    /**
     * Generates a functional ID with exactly 9 numeric digits.
     */
    private String IdGenerator() {
        StringBuilder id = new StringBuilder(EMPLOYEE_ID_LENGTH);
        Random random = new Random();

        for (int i = 0; i < EMPLOYEE_ID_LENGTH; i++) {
            int digit = random.nextInt(10);  // Generates a number from 0 to 9
            id.append(digit);
        }

        return id.toString();
    }
}