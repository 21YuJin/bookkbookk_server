package yuyu.bookkbookk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(length = 150)
    private String title;

    @Column(length = 1000)
    private String contents;

    @Column(length = 1000)
    private String url;

    @Column(length = 255)
    private String isbn;

    private LocalDate datetime;

    @Column(length = 255)
    private String authors; // List<String>로 사용 가능. 필요 시 변환 로직 추가

    @Column(length = 255)
    private String publisher;

    private Integer price;

    private Integer salePrice;

    @Column(length = 1000)
    private String thumbnail;

    @OneToMany(mappedBy = "book")
    private List<Report> reports = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<UserBook> userBooks = new ArrayList<>();

    // Getters and Setters
}

