package backapp.demo.models;

import backapp.demo.enums.UserType;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Embeddable
public class Role {
    private boolean isRegularUser=false;
    private boolean isAdministrator=false;
   

    public void setUserType(UserType userType) {
        switch (userType) {
            case REGULAR_USER:
                this.isRegularUser = true;
                break;
            case ADMINISTRATOR:
                this.isAdministrator = true;
                break;
        }

    }

}
