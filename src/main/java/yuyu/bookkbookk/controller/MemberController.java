package yuyu.bookkbookk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yuyu.bookkbookk.dto.memberDto.req.MemberReqDto;
import yuyu.bookkbookk.dto.memberDto.res.MemberResDto; // MemberResDto 임포트 추가
import yuyu.bookkbookk.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 가입
     **/
    @PostMapping("/signup")
    public ResponseEntity<MemberResDto> join(@RequestBody MemberReqDto memberDto) {
        System.out.println("Received MemberDto: " + memberDto);  // 입력 받은 값 확인
        MemberResDto createdMember = memberService.join(memberDto); // MemberResDto로 반환
        System.out.println("Created MemberDto: " + createdMember);  // 반환할 값 확인
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember); // 201 Created 응답
    }

    /**
     * 회원 로그인
     **/
    @PostMapping("/login")
    public ResponseEntity<MemberResDto> login(@RequestBody MemberReqDto memberDto) {
        // 클라이언트에서 JSON 요청으로 받은 name을 사용하여 로그인
        MemberResDto memberDtoResponse = memberService.login(memberDto.getName());
        return ResponseEntity.ok(memberDtoResponse); // 로그인 성공 시 200 OK
    }

    /**
     * 회원 전체 조회
     **/
    @GetMapping
    public ResponseEntity<List<MemberResDto>> findMembers() {
        List<MemberResDto> members = memberService.findMembers().stream()
                .map(MemberResDto::fromEntity) // MemberResDto로 변환
                .toList();
        return ResponseEntity.ok(members);
    }

    /**
     * 회원 단건 조회
     **/
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResDto> findOne(@PathVariable Long memberId) {
        MemberResDto memberDto = memberService.findOne(memberId)
                .map(MemberResDto::fromEntity) // MemberResDto로 변환
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        return ResponseEntity.ok(memberDto);
    }
}
