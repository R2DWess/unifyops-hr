package com.corp.unifyops.hr.employee.model.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class EmployeePhoneSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String employeePhone, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // Format the phone number to the format (XX) 9 XXXX-XXXX
        String formattedPhoneNumber = String.format("(%s) %s %s-%s",
                employeePhone.substring(0, 2),    // Area code
                employeePhone.substring(2, 3),    // Prefix 9
                employeePhone.substring(3, 7),    // First 4 digits
                employeePhone.substring(7, 11));  // Last 4 digits

        gen.writeString(formattedPhoneNumber);
    }
}
