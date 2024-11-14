package com.ziomson.department_service.service;

import com.ziomson.department_service.dto.DepartmentDto;
import com.ziomson.department_service.entity.Department;

public interface IDepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);

}
