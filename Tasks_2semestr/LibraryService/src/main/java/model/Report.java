package model;

import lombok.*;
import lombok.AllArgsConstructor;
import javax.persistence.*;
import java.util.List;
@Getter
@AllArgsConstructor
@Setter
@Entity
@Data
@Builder

@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 16)
    private String name;

    @OneToMany(mappedBy = "report", fetch = FetchType.EAGER)
    private List<User> users;

    @ManyToMany
    @JoinTable(
            name = "reports_topics",
            joinColumns = @JoinColumn(name = "report_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id")
    )
    private List<Topic> topics;


}
