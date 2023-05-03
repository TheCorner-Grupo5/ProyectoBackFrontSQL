package backapp.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import backapp.demo.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);

    @Query("SELECT u.email, u.password FROM User u WHERE u.email = :email AND u.password = :password")
    Object[] findUserCredentialsByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    
}
