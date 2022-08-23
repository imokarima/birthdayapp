package imoussoura.birthdayapp.controllers;

import imoussoura.birthdayapp.dtos.UserDto;
import imoussoura.birthdayapp.dtos.UserLoginDto;
import imoussoura.birthdayapp.entities.User;
import imoussoura.birthdayapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    ModelMapper modelMapper;
@Autowired
    UserService userService;

@PostMapping(value="/save")
    public ResponseEntity<User> saveUser(@RequestBody UserDto userDto){
    User user=userService.save(userDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
}

@GetMapping(value="/users")
    public ResponseEntity<List<User>> recupereAllUsers(){
    try{
        List<User> users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


@PostMapping(value="/userlogin")
    public ResponseEntity<User> getUser(@RequestBody UserLoginDto userLoginDto){
    try{
        User user=userService.login(userLoginDto);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id){
    return userService.findById(id);
    }

    @DeleteMapping(value="/deleteuser/{iduser}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long iduser) {
        try {
            userService.deleteUser(iduser);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/deletebirthdaysuser/{iduser}")
    public ResponseEntity<String> deleteBithdaysUserById(@PathVariable Long iduser) {
        try {
            userService.deleteBirthdaysUser(iduser);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
