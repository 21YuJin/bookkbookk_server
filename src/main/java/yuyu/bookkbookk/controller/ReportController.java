package yuyu.bookkbookk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yuyu.bookkbookk.dto.reportDto.req.PostReportReqDto;
import yuyu.bookkbookk.dto.reportDto.req.UpdateReportReqDto;
import yuyu.bookkbookk.dto.reportDto.res.ReportResDto;
import yuyu.bookkbookk.service.ReportService;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    // 독후감 생성
    @PostMapping
    public ResponseEntity<ReportResDto> createReport(@RequestBody PostReportReqDto postReportReqDto) {
        ReportResDto reportResDto = reportService.createReport(postReportReqDto);
        return ResponseEntity.ok(reportResDto);
    }

    // 독후감 조회
    @GetMapping("/{reportId}")
    public ResponseEntity<ReportResDto> getReport(@PathVariable Long reportId) {
        ReportResDto reportResDto = reportService.getReport(reportId);
        return ResponseEntity.ok(reportResDto);
    }

    // 독후감 수정
    @PutMapping("/{reportId}")
    public ResponseEntity<ReportResDto> updateReport(@PathVariable Long reportId, @RequestBody UpdateReportReqDto updateReportReqDto) {
        updateReportReqDto = new UpdateReportReqDto(reportId, updateReportReqDto.getMemberId(), updateReportReqDto.getBookId(), updateReportReqDto.getReportContent(), updateReportReqDto.getStartDate(), updateReportReqDto.getEndDate(), updateReportReqDto.getRating());
        ReportResDto reportResDto = reportService.updateReport(updateReportReqDto);
        return ResponseEntity.ok(reportResDto);
    }

    // 독후감 삭제
    @DeleteMapping("/{reportId}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long reportId) {
        reportService.deleteReport(reportId);
        return ResponseEntity.noContent().build();
    }
}
