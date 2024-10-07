package yuyu.bookkbookk.dto.reportDto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import yuyu.bookkbookk.domain.Report;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class ReportResDto {

    // 응답 DTO: reportId를 포함함 (클라이언트가 필요로 함)
    private Long reportId;        // 보고서 ID
    private Long memberId;        // 회원 ID
    private Long bookId;          // 책 ID
    private String reportContent;  // 보고서 내용
    private LocalDate startDate; // 시작일
    private LocalDate endDate;   // 종료일
    private Integer rating;         // 평가 점수

    // Report 객체를 기반으로 ReportResDto 객체 생성
    public static ReportResDto fromEntity(Report report) {
        return ReportResDto.builder()
                .reportId(report.getId())                      // 보고서 ID
                .memberId(report.getMember().getId())          // 회원 ID
                .bookId(report.getBook().getId())              // 책 ID
                .reportContent(report.getReportContent())       // 보고서 내용
                .startDate(report.getStartDate())               // 시작일
                .endDate(report.getEndDate())                   // 종료일
                .rating(report.getRating())                      // 평가 점수
                .build();
    }
}
