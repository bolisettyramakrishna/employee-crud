package example_temp.springboot_temp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
  private   String doorNo;
  private String streetName;
  private String city;
  private  String state;
  private String country;
  private Integer pincode;


//  private Employee employee;

}
