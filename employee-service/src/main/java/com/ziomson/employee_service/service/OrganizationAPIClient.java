package com.ziomson.employee_service.service;

import com.ziomson.employee_service.dto.DepartmentDto;
import com.ziomson.employee_service.dto.OrganizationDto;
import com.ziomson.employee_service.fallback.OrganizationApiFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "ORGANIZATION-SERVICE", fallback = OrganizationApiFallback.class)


public interface OrganizationAPIClient {

    @GetMapping("api/organizations/{code}")
    OrganizationDto getOrganization(@PathVariable("code") String organizationCode);
}
