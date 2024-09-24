package yuyu.bookkbookk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
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
    @OneToMany(mappedBy = "member")
    private List<Report> reports = new ArrayList<>();

    // 일대다 관계 설정 (MemberBook과 연관)
    @OneToMany(mappedBy = "member")
    private List<MemberBook> memberBooks = new ArrayList<>();
}
