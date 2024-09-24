package yuyu.bookkbookk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class AuthorBook {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_book_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
}
