package imoussoura.birthdayapp.services.impl;

import imoussoura.birthdayapp.entities.User;
import imoussoura.birthdayapp.repositories.UserRepository;
import imoussoura.birthdayapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User login(String username, String password) {
        try{
            User user =userRepository.findByUsernameAndPassword(username,password);
                return user;
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
         List<User> users=userRepository.findAll();
        return users;
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;

    }
}
