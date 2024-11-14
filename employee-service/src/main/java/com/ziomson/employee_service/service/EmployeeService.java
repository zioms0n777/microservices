package com.ziomson.employee_service.service;

import com.ziomson.employee_service.dto.APIResponseDto;
import com.ziomson.employee_service.dto.DepartmentDto;
import com.ziomson.employee_service.dto.EmployeeDto;
import com.ziomson.employee_service.entity.Employee;
import com.ziomson.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {

   private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
   // private RestTemplate restTemplate;
// private WebClient webClient;
private APIClient apiClient;
    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
Employee employee = modelMapper.map(employeeDto, Employee.class);
employeeRepository.save(employee);
return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
       Employee employee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));


       // REST TEMPLATE      ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//               DepartmentDto.class);
//       DepartmentDto departmentDto = responseEntity.getBody();

//   WEBFLUX   DepartmentDto departmentDto = webClient.get()
//                .uri("/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();


       DepartmentDto departmentDto =  apiClient.getDepartment(employee.getDepartmentCode());


       EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);


        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

       return apiResponseDto;
    }
}
