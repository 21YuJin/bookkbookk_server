package yuyu.bookkbookk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yuyu.bookkbookk.domain.Member;
import yuyu.bookkbookk.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public Long saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member findMember(Long id) {
        return memberRepository.find(id);
    }
}