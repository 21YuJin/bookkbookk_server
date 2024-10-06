package yuyu.bookkbookk.dto.reportDto.req;

import lombok.Getter;
import yuyu.bookkbookk.domain.Book;
import yuyu.bookkbookk.domain.Member;
import yuyu.bookkbookk.domain.Report;

import java.time.LocalDateTime;

@Getter
public class UpdateReportReq {

    private Long reportId; // 추가: 업데이트할 보고서 ID
    private Long memberId;
    private Long bookId;
    private String reportContent;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer rating;

    public Report toEntity(Member member, Book book) {
        return Report.builder()
                .member(member)  // member 객체 설정
                .book(book)      // book 객체 설정
                .reportContent(reportContent)
                .startDate(startDate)
                .endDate(endDate)
                .rating(rating)
                .build();
    }
}
