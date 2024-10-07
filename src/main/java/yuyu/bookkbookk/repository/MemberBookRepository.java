package yuyu.bookkbookk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yuyu.bookkbookk.domain.MemberBook;

import java.util.List;

public interface MemberBookRepository extends JpaRepository<MemberBook, Long> {

    List<MemberBook> findByMemberId(Long memberId);
}
