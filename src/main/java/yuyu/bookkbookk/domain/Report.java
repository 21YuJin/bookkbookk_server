package yuyu.bookkbookk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(length = 1000)
    private String reportContent;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer rating;

    private LocalDateTime reportDate;

    // Getters and Setters
}

