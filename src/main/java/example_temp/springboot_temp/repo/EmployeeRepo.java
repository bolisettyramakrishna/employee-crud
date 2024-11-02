package example_temp.springboot_temp.repo;

import example_temp.springboot_temp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
