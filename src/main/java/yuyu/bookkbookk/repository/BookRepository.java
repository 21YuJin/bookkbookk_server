package yuyu.bookkbookk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yuyu.bookkbookk.domain.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
}
