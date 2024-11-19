package com.ziomson.employee_service.fallback;

import com.ziomson.employee_service.dto.OrganizationDto;
import com.ziomson.employee_service.service.OrganizationAPIClient;
import org.springframework.stereotype.Component;

@Component
public class OrganizationApiFallback implements OrganizationAPIClient {
    @Override
    public OrganizationDto getOrganization(String organizationCode) {
        OrganizationDto fallbackDto = new OrganizationDto();
        fallbackDto.setId(666L);
        fallbackDto.setOrganizationName("Fallback Organization");
        fallbackDto.setOrganizationDescription("Organization Service Error");
        fallbackDto.setOrganizationCode("FAIL");
        return fallbackDto;
    }
}
