package backapp.demo.interfaces;

import java.util.List;

import backapp.demo.models.User;

public interface UserServiceInterface {
    
    public List<User> getAllUsers();

    public User addUser(User user);

    public User deleteUser(int id);

    public User updateUser(User user);
    
    public Object[] getEmailAndPassword(String email, String Password);

}
