package example_temp.springboot_temp.controller;


import example_temp.springboot_temp.dto.EmployeeDto;
import example_temp.springboot_temp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create-employee")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {


        return employeeService.addEmployee(employeeDto);

    }

    @GetMapping("hello")
    public  String sayHello(){
        return "Hello form employee controller";
    }


    @GetMapping("/get-employees")
    public List<EmployeeDto> getEmployees() {

        return employeeService.getEmployees();

    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long id) {


        return employeeService.getEmployeeById(id);

    }

    @GetMapping("/department-wise")
    public Map<String,List<EmployeeDto>>groupEmployees(){

        return employeeService.groupEmployeesByDepartment();
    }


    @PostMapping("/add-employee")
    public EmployeeDto addEmploye1e( @Valid  @RequestBody EmployeeDto employeeDto) {


        return employeeService.addEmployee(employeeDto);

    }

    @PutMapping("/update-employee/{id}")
    public EmployeeDto updateEmployee(@Valid @RequestBody EmployeeDto employeeDto, @PathVariable("id") Long id) {

        return employeeService.updateEmployee(employeeDto, id);

    }

    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {

        return employeeService.deleteById(id);
    }




}
