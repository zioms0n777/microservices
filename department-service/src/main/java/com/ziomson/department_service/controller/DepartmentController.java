package com.ziomson.department_service.controller;


import com.ziomson.department_service.dto.DepartmentDto;
import com.ziomson.department_service.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "Department Service - DepartmentController",
        description = "Department Controller Exposes REST APIs for Department-Service"
)
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Operation(summary = "Save Department REST API",
    description = "Save Department REST API is used to save department object in a database")
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
    try {
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    } catch (Exception e) {
        throw new RuntimeException("Could not create department", e);
    }

}


@GetMapping("/{code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("code") String departmentCode)
    {
        try {
           DepartmentDto departmentDto=  departmentService.getDepartmentByCode(departmentCode);
            return new ResponseEntity<>(departmentDto, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Could not get department by code");
        }
    }

}
