package imoussoura.birthdayapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -5712124030511257429L;

    public UserNotFoundException(Long id) {
        super("id " + id + " not found");
    }

    public UserNotFoundException() {
        super("login fail");
    }
}