package com.corp.unifyops.hr.employee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity(name = "employee")
@Table(name = "employee_data")
public class EmployeeData {

    @Id
    private String employeeId;
    @NotBlank(message = "The name field is required")
    private String employeeName;

    @NotBlank(message = "The email field is required")
    @Email(message = "Invalid email format")
    private String employeeEmail;

    @Pattern(regexp = "^\\d{11}$", message = "The phone number must have exactly 11 digits.")
    private String employeePhone;

    @NotBlank(message = "The age fild is required")
    private String employeeAge;

    private EmployeeAddressModel employeeAddress;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }


    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public EmployeeAddressModel getEmployeeAddress(){
        return employeeAddress;
    }

    public void setEmployeeAddress(EmployeeAddressModel employeeAddress){
        this.employeeAddress = employeeAddress;
    }
}