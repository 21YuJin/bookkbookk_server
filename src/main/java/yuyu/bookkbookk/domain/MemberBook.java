package yuyu.bookkbookk.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@Table(name = "member_book")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_book_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    private String status; // 책 상태 [Read, Not_Read, Reading]

    @Column(name = "is_liked") // 컬럼 이름 변경
    private Boolean isLiked; // 좋아요 유무

    @Column(name = "added_at") // 책이 목록에 추가된 날짜
    private LocalDateTime addedAt;

    @Builder // 빌더 패턴 사용
    public MemberBook(Member member, Book book, String status, Boolean isLiked) {
        this.member = member;
        this.book = book;
        this.status = status;
        this.isLiked = isLiked;
        this.addedAt = LocalDateTime.now(); // 현재 시간으로 추가 날짜 설정
    }
}
