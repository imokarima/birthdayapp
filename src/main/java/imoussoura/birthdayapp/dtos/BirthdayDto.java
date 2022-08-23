package imoussoura.birthdayapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BirthdayDto{
    private LocalDate date;
    private String firstname;
    private String lastname;
    private Long idUser;
}
