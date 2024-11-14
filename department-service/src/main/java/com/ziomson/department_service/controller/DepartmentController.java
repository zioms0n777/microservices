package com.ziomson.department_service.controller;


import com.ziomson.department_service.dto.DepartmentDto;
import com.ziomson.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

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
