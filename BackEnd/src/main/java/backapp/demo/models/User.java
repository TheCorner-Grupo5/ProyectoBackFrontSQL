package backapp.demo.models;

import backapp.demo.enums.UserType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  @Embedded
  private Role role=new Role();

  

  public User(String firstName,String lastName, String email,String password,UserType userType){
    this.firstName=firstName;
    this.lastName=lastName;
    this.email=email;
    this.password=password;
    role.setUserType(userType);
    
  }



}
