package example_temp.springboot_temp.service;

import example_temp.springboot_temp.dto.EmployeeDto;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getEmployees();

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployee(EmployeeDto employeeDto,Long id);

    String deleteById(Long id);

    Map<String, List<EmployeeDto>> groupEmployeesByDepartment();
}
