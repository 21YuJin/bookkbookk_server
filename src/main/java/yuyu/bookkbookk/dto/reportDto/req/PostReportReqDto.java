package yuyu.bookkbookk.dto.reportDto.req;

import lombok.Getter;
import yuyu.bookkbookk.domain.Book;
import yuyu.bookkbookk.domain.Member;
import yuyu.bookkbookk.domain.Report;

import java.time.LocalDate;

@Getter
public class PostReportReqDto {

    private Long memberId;
    private Long bookId;
    private String reportContent;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer rating;

    public Report toEntity(Member member, Book book) {
        return Report.builder()
                .member(member)
                .book(book)
                .reportContent(reportContent)
                .startDate(startDate)
                .endDate(endDate)
                .rating(rating)
                .build();
    }
}
