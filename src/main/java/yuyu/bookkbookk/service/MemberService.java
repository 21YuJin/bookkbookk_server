package yuyu.bookkbookk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yuyu.bookkbookk.domain.Member;
import yuyu.bookkbookk.dto.memberDto.req.MemberReqDto;
import yuyu.bookkbookk.dto.memberDto.res.MemberResDto;
import yuyu.bookkbookk.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     **/
    @Transactional
    public MemberResDto join(MemberReqDto memberDto) {
        // DTO에서 엔티티로 변환 후 저장
        Member member = memberDto.toEntity();
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member); // 엔티티 저장

        // 저장된 멤버를 DTO로 변환하여 반환
        return MemberResDto.fromEntity(member);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 로그인
     **/
    public MemberResDto login(String name) {
        Member member = memberRepository.findByName(name).stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다.")); // 예외 처리

        return MemberResDto.fromEntity(member); // 로그인 성공 시, 회원 정보를 DTO로 반환
    }

    /**
     * 회원 전체 조회
     **/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 단건 조회
     **/
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
