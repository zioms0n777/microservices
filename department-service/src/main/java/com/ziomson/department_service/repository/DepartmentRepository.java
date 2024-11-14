package com.ziomson.department_service.repository;

import com.ziomson.department_service.dto.DepartmentDto;
import com.ziomson.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository <Department, Long> {


    Department findByDepartmentCode(String departmentCode);

}
