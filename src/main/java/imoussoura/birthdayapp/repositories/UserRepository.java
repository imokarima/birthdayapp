package imoussoura.birthdayapp.repositories;

import imoussoura.birthdayapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u from User u WHERE u.username=:username and u.password=:password")
    User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
