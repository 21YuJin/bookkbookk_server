package yuyu.bookkbookk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import yuyu.bookkbookk.domain.Report;

@Entity
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 50)
    private String name;

    @Column(length = 255)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Report> reports = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserBook> userBooks = new ArrayList<>();

    // Getters and Setters
}
