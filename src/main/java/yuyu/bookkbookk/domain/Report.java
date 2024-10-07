package yuyu.bookkbookk.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 통한 직접 접근 차단
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    private String reportContent;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer rating;
    private LocalDate reportDate;

    @Builder
    public Report(Member member, Book book, String reportContent, LocalDate startDate,
                  LocalDate endDate, Integer rating) {
        this.member = member;
        this.book = book;
        this.reportContent = reportContent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
        this.reportDate = LocalDate.now(); // 생성 시 자동으로 현재 시간으로 설정
    }

    // 보고서가 완료되었는지 확인하는 메서드
    public boolean isReportComplete() {
        return this.endDate != null && this.rating != null;
    }

    //==연관 관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getReports().add(this);
    }

    public void setBook(Book book) {
        this.book = book;
        book.getReports().add(this);
    }

    //==비즈니스 로직==//
    /**
     * 독후감 삭제
     */
    public void deleteReport() {
        if (this.member != null) {
            this.member.getReports().remove(this);
        }
        if (this.book != null) {
            this.book.getReports().remove(this);
        }
    }

    /**
     * 독후감 수정
     */
    public void updateReport(String newContent, LocalDate newEndDate, Integer newRating) {
        if (newEndDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date cannot be before start date.");
        }
        this.reportContent = newContent;
        this.endDate = newEndDate;
        this.rating = newRating;
    }
}
