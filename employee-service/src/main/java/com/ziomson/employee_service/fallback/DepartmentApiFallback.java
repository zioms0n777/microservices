package com.ziomson.employee_service.fallback;

import com.ziomson.employee_service.dto.DepartmentDto;
import com.ziomson.employee_service.service.DepartmentAPIClient;
import org.springframework.stereotype.Component;

@Component
public class DepartmentApiFallback implements DepartmentAPIClient {

    @Override
    public DepartmentDto getDepartment(String departmentCode) {
        DepartmentDto fallbackDto = new DepartmentDto();
        fallbackDto.setId(666L);
        fallbackDto.setDepartmentName("Fallback Department");
        fallbackDto.setDepartmentDescription("Department service is unavailable");
        fallbackDto.setDepartmentCode(departmentCode);
        return fallbackDto;
    }
}

