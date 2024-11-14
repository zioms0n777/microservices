package com.ziomson.employee_service.service;

import com.ziomson.employee_service.dto.APIResponseDto;
import com.ziomson.employee_service.dto.EmployeeDto;

public interface IEmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long id);
}
