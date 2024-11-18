package com.corp.unifyops.hr.employee.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Embeddable
public record EmployeeAddressModel(

        @NotBlank(message = "The Street field is required")
        String street,

        @NotBlank(message = "The Number field is required")
        String number,

        String additionalAddressDetails,

        @NotBlank(message = "The Neighborhood field is required")
        String neighborhood,

        @NotBlank(message = "The City field is required")
        String city,

        @NotBlank
        @Pattern(regexp = "^[A-Z]{2}$", message = "State must have 2 uppercase letters")
        String state,

        @NotBlank
        @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "Invalid Postal Code, expected format: 00000-000")
        String postalCode
) {}