package yuyu.bookkbookk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yuyu.bookkbookk.domain.Book;
import yuyu.bookkbookk.domain.Member;
import yuyu.bookkbookk.domain.Report;
import yuyu.bookkbookk.dto.reportDto.req.PostReportReqDto;
import yuyu.bookkbookk.dto.reportDto.req.UpdateReportReqDto;
import yuyu.bookkbookk.dto.reportDto.res.ReportResDto;
import yuyu.bookkbookk.repository.BookRepository;
import yuyu.bookkbookk.repository.MemberRepository;
import yuyu.bookkbookk.repository.ReportRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportService {

    private final ReportRepository reportRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    // 독후감 생성
    @Transactional
    public ReportResDto createReport(PostReportReqDto postReportReqDto) {
        // Member 및 Book 객체 조회
        Member member = memberRepository.findById(postReportReqDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));
        Book book = bookRepository.findById(postReportReqDto.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));

        // Report 엔티티 생성
        Report report = postReportReqDto.toEntity(member, book);
        reportRepository.save(report);

        // 생성된 Report를 기반으로 응답 DTO 생성
        return ReportResDto.fromEntity(report);
    }

    // 독후감 조회
    public ReportResDto getReport(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("Report not found"));
        return ReportResDto.fromEntity(report);
    }

    // 독후감 수정
    @Transactional
    public ReportResDto updateReport(UpdateReportReqDto updateReportReqDto) {
        // 기존 Report 조회
        Report report = reportRepository.findById(updateReportReqDto.getReportId())
                .orElseThrow(() -> new IllegalArgumentException("Report not found"));

        // 연관된 Member 및 Book 객체 조회
        Member member = memberRepository.findById(updateReportReqDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid member ID"));
        Book book = bookRepository.findById(updateReportReqDto.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));

        // Report 수정
        report.updateReport(updateReportReqDto.getReportContent(), updateReportReqDto.getEndDate(), updateReportReqDto.getRating());
        report.setMember(member);
        report.setBook(book);

        // 수정된 Report를 기반으로 응답 DTO 생성
        return ReportResDto.fromEntity(report);
    }

    // 독후감 삭제
    @Transactional
    public void deleteReport(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("Report not found"));
        report.deleteReport();
        reportRepository.delete(report);
    }
}
