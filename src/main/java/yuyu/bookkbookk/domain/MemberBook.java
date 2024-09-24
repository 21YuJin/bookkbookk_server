package yuyu.bookkbookk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
@Table(name = "member_book")
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

    @Enumerated(EnumType.STRING) // ORDINAL(숫자로 들어감) -> 쓰면 안됨
    private BookStatus status; // 책 상태 [Read, Not_Read, Reading]

    @Column(name = "is_liked") // 컬럼 이름 변경
    private Boolean isLiked; // 좋아요 유무

    @Column(name = "added_at")
    private LocalDateTime addedAt;
}

