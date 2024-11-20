package com.corp.unifyops.hr.mapper;

import com.corp.unifyops.hr.dto.EmployeeDTO;
import com.corp.unifyops.hr.employee.model.EmployeeData;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeData toEntity(EmployeeDTO dto);
    EmployeeDTO toDTO(EmployeeData entity);
    void updateEntityFromDTO(EmployeeDTO dto, @MappingTarget EmployeeData entity);
}