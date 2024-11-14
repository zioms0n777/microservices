package com.ziomson.department_service.service;

import com.ziomson.department_service.dto.DepartmentDto;
import com.ziomson.department_service.entity.Department;
import com.ziomson.department_service.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto SavedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);
        return SavedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto DepartmentDtoByCode = modelMapper.map(department, DepartmentDto.class);
        return DepartmentDtoByCode;
    }
}
