package backapp.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import backapp.demo.models.User;
import backapp.demo.repositories.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
   
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public User addUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The user already exists in the repository");
        } else {
            return userRepository.saveAndFlush(user);
        }
    }
    

    public User deleteUser(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        userRepository.delete(user);
        return user;
    }


    public User updateUser(User user) {
        User userToUpdate = userRepository.findById(user.getId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        if (user.getFirstName() != null) {
            userToUpdate.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            userToUpdate.setLastName(user.getLastName());
        }
        if (user.getEmail() != null) {
            userToUpdate.setEmail(user.getEmail());
        }
 
        return userRepository.save(userToUpdate);
    }

  

}
