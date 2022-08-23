package imoussoura.birthdayapp.services.impl;

import imoussoura.birthdayapp.dtos.BirthdayDto;
import imoussoura.birthdayapp.dtos.BirthdayUpdateDto;
import imoussoura.birthdayapp.entities.Birthday;
import imoussoura.birthdayapp.entities.User;
import imoussoura.birthdayapp.repositories.BirthdayRepository;
import imoussoura.birthdayapp.repositories.UserRepository;
import imoussoura.birthdayapp.services.BirthdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
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
            return user.getBirthdayliste();
        }
        return null;
    }

    @Override
    public Birthday save(BirthdayDto birthdayDto) {
        Birthday birthday=new Birthday();
        Optional<User> userOp=userRepository.findById(birthdayDto.getIdUser());
        User user=userOp.get();
        birthday.setFirstname(birthdayDto.getFirstname());
        birthday.setLastname(birthdayDto.getLastname());
        birthday.setDate(birthdayDto.getDate());
        birthday.setUser(user);
        return birthdayRepository.save(birthday);

    }

    @Override
    public Birthday updateDate(BirthdayUpdateDto birthdayUpdateDto) {
        Optional<Birthday> birthdayOp=birthdayRepository.findById(birthdayUpdateDto.getIdBirthday());
        Birthday birthday=birthdayOp.get();
        birthday.setDate(birthdayUpdateDto.getDate());
        return birthdayRepository.save(birthday);
    }

}
