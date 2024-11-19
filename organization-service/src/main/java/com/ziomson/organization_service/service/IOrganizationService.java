package com.ziomson.organization_service.service;

import com.ziomson.organization_service.dto.OrganizationDto;

public interface IOrganizationService {

    OrganizationDto createOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByCode(String code);

}
