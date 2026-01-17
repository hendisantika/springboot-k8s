package id.my.hendisantika.springbootk8s.repository;

import id.my.hendisantika.springbootk8s.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-k8s
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/01/26
 * Time: 12.58
 * To change this template use File | Settings | File Templates.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
