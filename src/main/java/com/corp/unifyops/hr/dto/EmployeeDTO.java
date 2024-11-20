package com.corp.unifyops.hr.dto;

import com.corp.unifyops.hr.employee.model.embedded.EmployeeAddressModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EmployeeDTO {

    private String employeeId;

    @NotBlank(message = "The name field is required")
    private String employeeName;

    @NotBlank(message = "The email field is required")
    @Email(message = "Invalid email format")
    private String employeeEmail;

    @Pattern(regexp = "^\\d{11}$", message = "The phone number must have exactly 11 digits.")
    private String employeePhone;

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

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(String employeeAge) {
        this.employeeAge = employeeAge;
    }

    public EmployeeAddressModel getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(EmployeeAddressModel employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
}