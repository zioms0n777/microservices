package com.ziomson.organization_service.service;

import com.ziomson.organization_service.dto.OrganizationDto;
import com.ziomson.organization_service.entity.Organization;
import com.ziomson.organization_service.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationService implements IOrganizationService {

private OrganizationRepository organizationRepository;
    private ModelMapper modelMapper;
    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        Organization organization = modelMapper.map(organizationDto, Organization.class);
        organizationRepository.save(organization);
        return modelMapper.map(organization, OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String code) {
        Organization organization = organizationRepository.findByOrganizationCode(code);
        return modelMapper.map(organization, OrganizationDto.class);
    }
}
