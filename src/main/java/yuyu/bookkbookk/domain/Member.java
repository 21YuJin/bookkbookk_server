package yuyu.bookkbookk.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 통해서 값 변경 목적으로 접근하는 메시지들 차단
                                                   // private가 아니라 protected로 적용함으로써 프록시 객체를 생성
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Embedded
    private Address address;

    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String phone;

    // 일대다 관계 설정 (Report와 연관)
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Report> reports = new ArrayList<>();

    // 일대다 관계 설정 (MemberBook과 연관)
    // @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberBook> memberBooks = new ArrayList<>();

    @Builder // 빌더 패턴 사용
    public Member(String name, Address address, String email, String phone) {
        this.name = name;
        this.address= address;
        this.email = email;
        this.phone = phone;
    }

    //==연관관계 메서드==//
    // 리포트 추가 메서드
    public void addReport(Report report) {
        reports.add(report);
        report.setMember(this); // 양방향 관계 설정
    }

    // MemberBook 추가 메서드
    public void addMemberBook(MemberBook memberBook) {
        memberBooks.add(memberBook);
        memberBook.setMember(this); // 양방향 관계 설정
    }
}
