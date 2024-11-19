package com.ziomson.employee_service.service;

import com.ziomson.employee_service.dto.DepartmentDto;
import com.ziomson.employee_service.fallback.DepartmentApiFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "DEPARTMENT-SERVICE", fallback = DepartmentApiFallback.class)
public interface DepartmentAPIClient {

    @GetMapping("api/departments/{code}")
    DepartmentDto getDepartment(@PathVariable("code") String departmentCode);



}
