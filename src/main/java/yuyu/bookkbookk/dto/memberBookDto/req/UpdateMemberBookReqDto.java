package yuyu.bookkbookk.dto.memberBookDto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateMemberBookReqDto {

    private Long memberBookId; // MemberBook ID
    private Long bookId; // Book ID
    private String status; // Book status
    private Boolean isLiked; // Liked status

    // 빌더 패턴 사용해서 선택적으로 값을 넣게 해줘
}
