package imoussoura.birthdayapp.services.impl;

import imoussoura.birthdayapp.entities.Birthday;
import imoussoura.birthdayapp.entities.User;
import imoussoura.birthdayapp.repositories.BirthdayRepository;
import imoussoura.birthdayapp.repositories.UserRepository;
import imoussoura.birthdayapp.services.BirthdayService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BirthdayServiceImpl implements BirthdayService {
    @Autowired
    BirthdayRepository birthdayRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public List<Birthday> getAllBirthdays() {
        return birthdayRepository.findAll();
    }

    @Override
    public List<Birthday> getBirthdaysByUserId(Long userId) {
        Optional<User> userOp=userRepository.findById(userId);
        User user;
        if(userOp.isPresent()){
            user=userOp.get();
            //return user.getBirthdayliste();
            return null;
        }

        return null;
    }

    @Override
    public Birthday save(Birthday birthday) {
        return null;
    }
}
