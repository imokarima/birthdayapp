package imoussoura.birthdayapp.services;

import imoussoura.birthdayapp.dtos.UserDto;
import imoussoura.birthdayapp.dtos.UserLoginDto;
import imoussoura.birthdayapp.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    public User login(UserLoginDto userLoginDto);
    public List<User> getAllUsers();
    public User save(UserDto userDto);
    public User findById(Long id);
    String deleteUser(Long id);
    String deleteBirthdaysUser(Long id);
}
