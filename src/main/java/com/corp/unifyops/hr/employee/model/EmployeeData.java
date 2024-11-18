package com.corp.unifyops.hr.employee.model;

import jakarta.persistence.*;

@Entity(name = "employee")
@Table(name = "employee_data")
public class EmployeeData {

    @Id
    private String employeeId;
    private String name;
    private String age;
    private EmployeeAddressModel employeeAddress;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public EmployeeAddressModel getEmployeeAddress(){
        return employeeAddress;
    }

    public void setEmployeeAddress(EmployeeAddressModel employeeAddress){
        this.employeeAddress = employeeAddress;
    }
}