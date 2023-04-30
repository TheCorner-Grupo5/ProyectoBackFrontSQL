package backapp.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Data {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String avatar;

    public Data(String firstName, String lastName,String email, String avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatar = avatar;
    }


}
