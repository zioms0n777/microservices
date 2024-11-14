package com.ziomson.employee_service.service;

import com.ziomson.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("api/departments/{code}")
    DepartmentDto getDepartment(@PathVariable("code") String departmentCode);
}
