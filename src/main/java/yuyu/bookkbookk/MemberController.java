package yuyu.bookkbookk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yuyu.bookkbookk.domain.Member;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Member member) {
        try {
            memberService.saveMember(member);
            return ResponseEntity.status(201).body(new ResponseMessage("success", "회원가입이 완료되었습니다."));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new ResponseMessage("error", "회원가입에 실패했습니다. 입력 정보를 확인하세요."));
        }
    }
}
