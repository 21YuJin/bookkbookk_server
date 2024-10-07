package yuyu.bookkbookk.dto.memberDto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yuyu.bookkbookk.domain.Address;
import yuyu.bookkbookk.domain.Member;

@Getter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자
@Builder
public class MemberResDto {

    private Long memberId; // Member ID
    private String name;
    private Address address;
    private String email;
    private String phone;

    // 엔티티를 DTO로 변환하는 메서드
    public static MemberResDto fromEntity(Member member) {
        return MemberResDto.builder()
                .memberId(member.getId()) // Member ID 추가
                .name(member.getName())
                .address(member.getAddress())
                .email(member.getEmail())
                .phone(member.getPhone())
                .build();
    }
}
