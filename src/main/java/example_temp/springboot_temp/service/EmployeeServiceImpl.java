package example_temp.springboot_temp.service;

import example_temp.springboot_temp.dto.EmployeeDto;
import example_temp.springboot_temp.repo.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import example_temp.springboot_temp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {




        Employee employee=modelMapper.map(employeeDto,Employee.class);

      employee= employeeRepo.save(employee);

      return modelMapper.map(employee,EmployeeDto.class);

    }

    @Override
    public List<EmployeeDto> getEmployees() {
       return employeeRepo.findAll().stream().map((e)->modelMapper.map(e, EmployeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {

        Employee e= employeeRepo.findById(id).get();
        return modelMapper.map(e, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto,Long id) {

        Optional<Employee>e=employeeRepo.findById(id);

        if(e.isPresent()){
            Employee employee=modelMapper.map(employeeDto,Employee.class);
            employee.setId(e.get().getId());
            employeeRepo.save(employee);

            return modelMapper.map(employee,EmployeeDto.class);
        }
        return null;

    }

    @Override
    public String deleteById(Long id) {

        if(employeeRepo.findById(id).isPresent()){

            employeeRepo.deleteById(id);
            if(employeeRepo.findById(id).isEmpty()){
              return "Deleted succesfully ";
            }
            else{
                return " some error occured";
            }
        }
        return "Not id found with id "+id;


    }

    @Override
    public Map<String, List<EmployeeDto>> groupEmployeesByDepartment() {

        HashMap<String,List<EmployeeDto>>hashMap=new HashMap<>();
        List<Employee>empList=employeeRepo.findAll();

        for(Employee e:empList){
        if(e.getDepartment()==null)continue;
            if(hashMap.containsKey(e.getDepartment())){
                EmployeeDto empDto=modelMapper.map(e,EmployeeDto.class);
                hashMap.getOrDefault(e.getDepartment(), new ArrayList<>()).add(empDto);
            }else{
                EmployeeDto empDto=modelMapper.map(e,EmployeeDto.class);
                hashMap.put(e.getDepartment(),new ArrayList<>(Arrays.asList(empDto)));

            }

        }
        return hashMap;

    }

}

