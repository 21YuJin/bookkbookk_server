package yuyu.bookkbookk.dto.memberDto;

import yuyu.bookkbookk.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import yuyu.bookkbookk.domain.Address;

@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 자동으로 생성
@AllArgsConstructor // 모든 필드를 파라미터로 받는 생성자를 자동으로 생성
@Builder
public class MemberDto {

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

//     이미 MemberDto가 갖고 있는 필드 값을 사용하면 되는데, 굳이 파라미터로 다시 전달받을 필요가 없다.
//     name, address, email, phone은 클래스 필드에서 직접 가져오는 것이 더 효율적
//    public Member toEntity(String name, Address address, String email, String phone) {
//        return Member.builder()
//                .name(name)
//                .address(address)
//                .email(email)
//                .phone(phone)
//                .build();
//    }

    // 엔티티를 DTO로 변환하는 메서드
    public static MemberDto fromEntity(Member member) {
        return MemberDto.builder()
                .name(member.getName())
                .address(member.getAddress())
                .email(member.getEmail())
                .phone(member.getPhone())
                .build();
    }
}
