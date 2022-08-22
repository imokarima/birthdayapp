package imoussoura.birthdayapp.services;

import imoussoura.birthdayapp.entities.User;

import java.util.List;

public interface UserService {

    public User login(String username, String password);
    public List<User> getAllUsers();
    public User save(User user);
}
