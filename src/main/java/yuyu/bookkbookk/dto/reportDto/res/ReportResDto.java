package yuyu.bookkbookk.dto.reportDto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import yuyu.bookkbookk.domain.Report;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ReportRes {

    // 응답 DTO: reportId를 포함함 (클라이언트가 필요로 함)
    private Long reportId; // 보고서 ID
    private Long memberId; // 회원 ID
    private Long bookId;   // 책 ID
    private String reportContent; // 보고서 내용
    private LocalDateTime startDate; // 시작일
    private LocalDateTime endDate;   // 종료일
    private Integer rating; // 평가 점수

    // Report 객체를 기반으로 ReportRes 객체 생성
    public ReportRes(Report report) {
        this.reportId = report.getId();
        this.memberId = report.getMember().getId(); // 연관된 회원의 ID
        this.bookId = report.getBook().getId(); // 연관된 책의 ID
        this.reportContent = report.getReportContent();
        this.startDate = report.getStartDate();
        this.endDate = report.getEndDate();
        this.rating = report.getRating();
    }
}
