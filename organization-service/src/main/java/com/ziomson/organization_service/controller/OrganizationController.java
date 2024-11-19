package com.ziomson.organization_service.controller;

import com.ziomson.organization_service.dto.OrganizationDto;
import com.ziomson.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;


@PostMapping("/create")
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto) {
        try {
            OrganizationDto organizationCreated = organizationService.createOrganization(organizationDto);
            return new ResponseEntity<>(organizationCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException("Could not create organization", e);
        }

    }

    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String code) {
        try {
            OrganizationDto organizationByCode = organizationService.getOrganizationByCode(code);
            return new ResponseEntity<>(organizationByCode, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("There is no organization with code " + code);
        }
    }



}


