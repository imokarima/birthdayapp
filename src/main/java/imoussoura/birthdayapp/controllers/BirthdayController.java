package imoussoura.birthdayapp.controllers;

import imoussoura.birthdayapp.dtos.BirthdayDto;
import imoussoura.birthdayapp.dtos.BirthdayUpdateDto;
import imoussoura.birthdayapp.entities.Birthday;
import imoussoura.birthdayapp.entities.User;
import imoussoura.birthdayapp.services.BirthdayService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/birthday")
public class BirthdayController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BirthdayService birthdayService;

    @PostMapping(value="/save")
    public ResponseEntity<Birthday> createBirthday(@RequestBody BirthdayDto birthdayDto){
        Birthday birthday=birthdayService.save(birthdayDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(birthday);
    }


    @GetMapping(value="/birthdays")
    public ResponseEntity<List<Birthday>> recupereAllBirthdays(){
        try{
            List<Birthday> birthdays=birthdayService.getAllBirthdays();
            return new ResponseEntity<>(birthdays,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="userbirthdays/{iduser}")
    public ResponseEntity<List<Birthday>> birthdaysByUserId(@PathVariable Long iduser){
        List<Birthday> birthdays= birthdayService.getBirthdaysByUserId(iduser);
        return new ResponseEntity<>(birthdays,HttpStatus.OK);
    }

    @PutMapping(value="/dateupdate")
    public ResponseEntity<Birthday> updateDateBirthday(@RequestBody BirthdayUpdateDto birthdayUpdateDto){
        Birthday birthday=birthdayService.updateDate(birthdayUpdateDto);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(birthday);
    }

}
