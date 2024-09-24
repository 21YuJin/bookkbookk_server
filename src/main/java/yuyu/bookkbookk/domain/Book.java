package yuyu.bookkbookk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String title;
    private String contents;
    private String url;
    private String isbn;
    private String publisher;
    private Integer price;

    @Column(name = "sale_price")
    private Integer salePrice;

    @Column(name = "thumbnail")
    private String thumbnail;

    // 일대다 관계 설정 (Report와 연관)
    @OneToMany(mappedBy = "book")
    private List<Report> reports = new ArrayList<>();

    // 일대다 관계 설정 (MemberBook과 연관)
    @OneToMany(mappedBy = "book")
    private List<MemberBook> memberBooks = new ArrayList<>();

    // 일대다 관계 설정 (AuthorBook과 연관)
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AuthorBook> authorBooks = new ArrayList<>();

}
