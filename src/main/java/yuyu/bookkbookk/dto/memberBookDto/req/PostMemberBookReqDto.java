package yuyu.bookkbookk.dto.memberBookDto.req;

import lombok.*;
import yuyu.bookkbookk.domain.Book;
import yuyu.bookkbookk.domain.Member;
import yuyu.bookkbookk.domain.MemberBook;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostMemberBookReqDto {

    private Long memberId;  // 멤버 ID
    private Long bookId;    // 책 ID
    private String status; // 상태 (READING, READ, NOT_READ)
    private Boolean isLiked; // 좋아요 여부

    // DTO를 엔티티로 변환하는 메서드
    public MemberBook toEntity(Member member, Book book) {
        return MemberBook.builder()
                .member(member)
                .book(book)
                .status(this.status)
                .isLiked(this.isLiked)
                .build();
    }
}
