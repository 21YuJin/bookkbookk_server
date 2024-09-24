package yuyu.bookkbookk;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yuyu.bookkbookk.domain.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
// @Transactional
public class MemberRepositoryTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void testMember() throws Exception {
        // given
        Member member = new Member();
        member.setName("memberA");

        // when
        Long saveId = memberService.saveMember(member);
        Member findMember = memberService.findMember(saveId);

        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
    }
}
