package com.corp.unifyops.hr.employee.repository;

import com.corp.unifyops.hr.employee.model.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeData, Integer> {

    boolean existsByEmployeeId(String id);

    void deleteByEmployeeId(String employeeId);

    Optional<EmployeeData> findByEmployeeId(String employeeId);
}
