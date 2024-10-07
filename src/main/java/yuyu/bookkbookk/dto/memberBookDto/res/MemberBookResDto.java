package yuyu.bookkbookk.dto.memberBookDto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yuyu.bookkbookk.domain.MemberBook;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberBookResDto {

    private Long memberBookId; // MemberBook ID
    private Long memberId; // Member ID
    private Long bookId; // Book ID
    private String bookTitle; // Book title
    private String bookAuthor; // Book author
    private String status; // Book status
    private Boolean isLiked; // Liked status
    private LocalDateTime addedAt; // Added date and time

    // 엔티티를 DTO로 변환하는 메서드
    public static MemberBookResDto fromEntity(MemberBook memberBook) {
        return MemberBookResDto.builder()
                .memberBookId(memberBook.getId())
                .memberId(memberBook.getMember().getId())
                .bookId(memberBook.getBook().getId())
                .bookTitle(memberBook.getBook().getTitle())
                .bookAuthor(memberBook.getBook().getAuthor())
                .status(memberBook.getStatus())
                .isLiked(memberBook.getIsLiked())
                .addedAt(memberBook.getAddedAt())
                .build();
    }
}
