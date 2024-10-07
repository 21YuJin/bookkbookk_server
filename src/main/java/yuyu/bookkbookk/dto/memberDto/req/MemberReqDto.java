package yuyu.bookkbookk.dto.memberDto.req;

import yuyu.bookkbookk.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import yuyu.bookkbookk.domain.Address;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자
@Builder
public class MemberReqDto {

    private String name;
    private Address address;
    private String email;
    private String phone;

    // DTO를 엔티티로 변환하는 메서드
    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .address(this.address)
                .email(this.email)
                .phone(this.phone)
                .build();
    }
}
