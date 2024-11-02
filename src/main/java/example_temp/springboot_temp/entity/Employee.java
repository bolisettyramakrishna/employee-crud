package example_temp.springboot_temp.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String firstName;
    private String lastName;
    private String department;
    @Column(unique = true)
    private String email;
    private Long salary;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private List<Address> addressList;

}
