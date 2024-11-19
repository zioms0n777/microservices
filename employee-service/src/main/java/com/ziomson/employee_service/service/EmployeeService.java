package com.ziomson.employee_service.service;

import com.ziomson.employee_service.dto.APIResponseDto;
import com.ziomson.employee_service.dto.DepartmentDto;
import com.ziomson.employee_service.dto.EmployeeDto;
import com.ziomson.employee_service.dto.OrganizationDto;
import com.ziomson.employee_service.entity.Employee;
import com.ziomson.employee_service.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {

   private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
   // private RestTemplate restTemplate;
// private WebClient webClient;
private DepartmentAPIClient departmentApiClient;
private OrganizationAPIClient organizationApiClient;
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


       DepartmentDto departmentDto =  departmentApiClient.getDepartment(employee.getDepartmentCode());
        OrganizationDto organizationDto = organizationApiClient.getOrganization(employee.getOrganizationCode());

       EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);


        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
       return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long id, Exception exception) {


        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
        DepartmentDto departmentDto =  new DepartmentDto();
        departmentDto.setDepartmentName("Dev Department");
        departmentDto.setDepartmentDescription("Probably department service off");
        departmentDto.setDepartmentCode("DSOFF");


        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);


        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;

    }
}
