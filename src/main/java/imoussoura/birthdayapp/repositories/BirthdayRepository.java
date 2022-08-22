package imoussoura.birthdayapp.repositories;

import imoussoura.birthdayapp.entities.Birthday;
import imoussoura.birthdayapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayRepository extends JpaRepository<Birthday, Long> {
}
