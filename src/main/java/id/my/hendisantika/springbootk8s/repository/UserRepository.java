package id.my.hendisantika.springbootk8s.repository;

import id.my.hendisantika.springbootk8s.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-k8s
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/01/26
 * Time: 13.00
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u WHERE u.email=?1")
    User findByEmail(String email);

    User findByUsername(String username);

    User findByUsernameOrEmail(String username, String email);

    @Query(name = "User.findByUsernameAll")
    String findByUsernameAll(@Param("userName") String userName);
}
