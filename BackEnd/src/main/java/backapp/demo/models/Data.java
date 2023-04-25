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
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    public Data(String email, String first_name, String last_name, String avatar) {
        this.email = email
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }


	
}
