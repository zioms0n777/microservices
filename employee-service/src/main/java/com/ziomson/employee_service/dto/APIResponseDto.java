package com.ziomson.employee_service.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {
    private DepartmentDto departmentDto;
    private EmployeeDto employeeDto;
    private OrganizationDto organizationDto;
}
