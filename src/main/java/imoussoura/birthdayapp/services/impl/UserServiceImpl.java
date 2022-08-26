package imoussoura.birthdayapp.services.impl;

import imoussoura.birthdayapp.dtos.UserDto;
import imoussoura.birthdayapp.dtos.UserLoginDto;
import imoussoura.birthdayapp.entities.Birthday;
import imoussoura.birthdayapp.entities.User;
import imoussoura.birthdayapp.repositories.BirthdayRepository;
import imoussoura.birthdayapp.repositories.UserRepository;
import imoussoura.birthdayapp.security.MyUserPrincipal;
import imoussoura.birthdayapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService , UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BirthdayRepository birthdayRepository;
    @Override
    public User login(UserLoginDto userLoginDto) {
        try{
            User user =userRepository.findByUsernameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());
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
    public User save(UserDto userDto) {
        User user=new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOp= userRepository.findById(id);
        if(userOp.isPresent()){
            return userOp.get();
        }
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        Optional<User> userOp=userRepository.findById(id);
        User user=userOp.get();
        List<Birthday> liste=user.getBirthdayliste();
        if(user!=null){
            for (Birthday b:liste
                 ) {
                birthdayRepository.delete(b);
            }
            userRepository.delete(user);
            return "user deleted";
        }
        return null;
    }

    @Override
    public String deleteBirthdaysUser(Long id) {
        Optional<User> userOp=userRepository.findById(id);
        User user=userOp.get();
        List<Birthday> liste=user.getBirthdayliste();
        if(user!=null) {
            for (Birthday b : liste
            ) {
                birthdayRepository.delete(b);
            }
            return "liste birthday deleted";
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        System.out.println("-----------> " + optionalUser);

        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(optionalUser.get());

    }

}
