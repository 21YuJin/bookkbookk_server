package yuyu.bookkbookk.dto.bookDto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import yuyu.bookkbookk.domain.Book;

@Getter
@Builder
@AllArgsConstructor
public class BookResDto {

    private Long bookId; // 책 ID
    private String title;
    private String contents;
    private String url;
    private String isbn;
    private String publisher;
    private String author;
    private Integer salePrice;
    private String thumbnail;

    public BookResDto(Book book) {
        this.bookId = book.getId();
        this.title = book.getTitle();
        this.contents = book.getContents();
        this.url = book.getUrl();
        this.isbn = book.getIsbn();
        this.publisher = book.getPublisher();
        this.author = book.getAuthor();
        this.salePrice = book.getSalePrice();
        this.thumbnail = book.getThumbnail();
    }
}
