package yuyu.bookkbookk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yuyu.bookkbookk.domain.Book;
import yuyu.bookkbookk.domain.Member;
import yuyu.bookkbookk.domain.MemberBook;
import yuyu.bookkbookk.dto.bookDto.res.BookResDto;
import yuyu.bookkbookk.dto.memberBookDto.req.PostMemberBookReqDto;
import yuyu.bookkbookk.dto.memberBookDto.req.UpdateMemberBookReqDto;
import yuyu.bookkbookk.dto.memberBookDto.res.MemberBookResDto;
import yuyu.bookkbookk.repository.BookRepository;
import yuyu.bookkbookk.repository.MemberBookRepository;
import yuyu.bookkbookk.repository.MemberRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 읽기 전용 트랜잭션
public class BookService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final MemberBookRepository memberBookRepository;

    // 책 검색 (BookResDto로 변환)
    public List<BookResDto> searchBooks(String title) {
        List<Book> books = bookRepository.findByTitleContaining(title);
        return books.stream().map(BookResDto::new).collect(Collectors.toList());
    }

    @Transactional // 데이터 수정이 이루어지므로 트랜잭션 활성화
    public void addBookToMember(PostMemberBookReqDto dto) {
        Optional<Member> member = memberRepository.findById(dto.getMemberId());
        Optional<Book> book = bookRepository.findById(dto.getBookId());

        if (member.isEmpty() || book.isEmpty()) {
            throw new IllegalStateException("Member or Book not found");
        }

        // 멤버가 책에 대한 상태 추가
        MemberBook memberBook = MemberBook.builder()
                .member(member.get())
                .book(book.get())
                .status(dto.getStatus())
                .isLiked(dto.getIsLiked())
                .build(); // 빌더 패턴을 사용하여 객체 생성

        memberBookRepository.save(memberBook);
    }


    // 멤버가 읽기 여부 상태 업데이트
    @Transactional
    public void updateBookStatus(UpdateMemberBookReqDto dto) {
        System.out.println("Updating book status for memberBookId = " + dto.getMemberBookId());

        MemberBook memberBook = memberBookRepository.findById(dto.getMemberBookId())
                .orElseThrow(() -> new IllegalStateException("MemberBook relationship not found"));

        memberBook.setStatus(dto.getStatus());
        memberBookRepository.save(memberBook);
    }


    // 멤버가 좋아요 상태 업데이트
    @Transactional
    public void updateLikeStatus(UpdateMemberBookReqDto dto) {
        System.out.println("Updating book IsLiked for memberBookId = " + dto.getMemberBookId());

        MemberBook memberBook = memberBookRepository.findById(dto.getMemberBookId())
                .orElseThrow(() -> new IllegalStateException("MemberBook relationship not found"));

        // 좋아요 상태 업데이트
        memberBook.setIsLiked(dto.getIsLiked());
        memberBookRepository.save(memberBook);
    }

    // 특정 멤버가 읽고 있는 책 목록 조회
    public List<MemberBookResDto> getBooksByMember(Long memberId) {
        List<MemberBook> memberBooks = memberBookRepository.findByMemberId(memberId);
        return memberBooks.stream().map(MemberBookResDto::fromEntity)
                .collect(Collectors.toList());
    }
}
