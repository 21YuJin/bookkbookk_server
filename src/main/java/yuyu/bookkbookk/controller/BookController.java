package yuyu.bookkbookk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yuyu.bookkbookk.dto.bookDto.res.BookResDto;
import yuyu.bookkbookk.dto.memberBookDto.req.PostMemberBookReqDto;
import yuyu.bookkbookk.dto.memberBookDto.req.UpdateMemberBookReqDto;
import yuyu.bookkbookk.dto.memberBookDto.res.MemberBookResDto;
import yuyu.bookkbookk.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 책 검색
    @GetMapping("/search")
    public ResponseEntity<List<BookResDto>> searchBooks(@RequestParam String title) {
        List<BookResDto> books = bookService.searchBooks(title);
        return ResponseEntity.ok(books);
    }

    // 멤버가 책을 추가
    @PostMapping("/member")
    public ResponseEntity<Void> addBookToMember(@RequestBody PostMemberBookReqDto dto) {
        bookService.addBookToMember(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created
    }

    // 멤버가 읽은 책 상태 업데이트
    @PutMapping("/member/status")
    public ResponseEntity<Void> updateBookStatus(@RequestBody UpdateMemberBookReqDto dto) {
        bookService.updateBookStatus(dto);
        return ResponseEntity.ok().build(); // 200 OK
    }


    // 멤버가 좋아요 상태 업데이트
    @PutMapping("/member/like")
    public ResponseEntity<Void> updateLikeStatus(@RequestBody UpdateMemberBookReqDto dto) {
        bookService.updateLikeStatus(dto);
        return ResponseEntity.ok().build(); // 200 OK
    }

    // 특정 멤버가 읽고 있는 책 목록 조회
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<MemberBookResDto>> getBooksByMember(@PathVariable Long memberId) {
        List<MemberBookResDto> memberBooks = bookService.getBooksByMember(memberId);
        return ResponseEntity.ok(memberBooks);
    }
}
