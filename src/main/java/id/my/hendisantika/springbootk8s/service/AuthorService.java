package id.my.hendisantika.springbootk8s.service;

import id.my.hendisantika.springbootk8s.model.Author;
import id.my.hendisantika.springbootk8s.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-k8s
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/01/26
 * Time: 13.01
 * To change this template use File | Settings | File Templates.
 */
@Service
@AllArgsConstructor
public class AuthorService {
    private AuthorRepository authorRepository;

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
}
