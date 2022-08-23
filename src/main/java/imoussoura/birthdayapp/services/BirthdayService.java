package imoussoura.birthdayapp.services;

import imoussoura.birthdayapp.dtos.BirthdayDto;
import imoussoura.birthdayapp.dtos.BirthdayUpdateDto;
import imoussoura.birthdayapp.entities.Birthday;

import java.util.List;
import java.util.Set;

public interface BirthdayService {
     List<Birthday> getAllBirthdays();
     List<Birthday> getBirthdaysByUserId(Long userId);
     Birthday save(BirthdayDto birthdayDto);

     Birthday updateDate(BirthdayUpdateDto birthdayUpdateDto);
}
