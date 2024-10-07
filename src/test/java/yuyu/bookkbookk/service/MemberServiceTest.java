//package yuyu.bookkbookk.service;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//import yuyu.bookkbookk.domain.Member;
//import yuyu.bookkbookk.repository.MemberRepository;
//
//import static org.assertj.core.api.Fail.fail;
//
//
//// 아래 두 가지가 있어야 Spring이랑 Integration해서 Test를 할 수 있음
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional // Rollback 위해 // 같은 영속성 컨텍스트 내에서 관리
//public class MemberServiceTest {
//
//    @Autowired MemberService memberService;
//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    // @Rollback(false) // rollback을 하지 않고 commit
//    public void 회원가입() throws Exception {
//        //given
//        Member member = new Member();
//        member.setName("kim");
//
//        //when
//        Long saveId = memberService.join(member);
//
//        //then
//        // assertEquals(member, memberRepository.findOne(saveId));
//    }
//
//    @Test(expected = IllegalStateException.class)
//    public void 중복_회원_예외() throws Exception {
//        //given
//        Member member1 = new Member();
//        member1.setName("kim");
//
//        Member member2 = new Member();
//        member2.setName("kim");
//
//        //when
//        memberService.join(member1);
//        memberService.join(member2); // 예외가 발생
//
//        //then
//        fail("예외가 발생해야 한다.");
//    }
//
//}