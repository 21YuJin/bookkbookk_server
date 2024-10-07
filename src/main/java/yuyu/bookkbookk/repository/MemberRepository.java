package yuyu.bookkbookk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yuyu.bookkbookk.domain.Member;

import java.util.List;

// JPARepository <Entity, 기본키 타입> => CRUD 자동 생성
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);
}
