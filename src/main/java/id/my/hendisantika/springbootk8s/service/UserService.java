package id.my.hendisantika.springbootk8s.service;

import id.my.hendisantika.springbootk8s.model.User;
import id.my.hendisantika.springbootk8s.repository.UserRepository;
import jakarta.persistence.Cacheable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-k8s
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/01/26
 * Time: 13.07
 * To change this template use File | Settings | File Templates.
 */
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;


    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Cacheable("users")
    public User getUserById(Long userId) {
        if (userId == null) {
            return null;
        }
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);


    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User findByUserEmail(String userEmail) {

        return userRepository.findByEmail(userEmail);
    }

    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User findByUsernameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username, email);
    }

    public String findByUsernameAll(String userName) {
        return userRepository.findByUsernameAll(userName);
    }

}
