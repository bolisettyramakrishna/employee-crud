package example_temp.springboot_temp.dto;

import example_temp.springboot_temp.entity.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    @NotBlank(message = "firstName should not empty")
    private String firstName;
    @NotBlank(message = "lastname should not empty")
    private String lastName;
    @NotBlank(message = "department should not empty")
    private String department;
    @NotBlank(message = "email should not empty")
    private String email;
    private Long salary;

    private List<Address> addressList;
}
