package com.ziomson.organization_service.repository;


import com.ziomson.organization_service.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long>{
    Organization findByOrganizationCode(String organizationCode);
}
